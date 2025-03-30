/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.CreativeSpace;
import Model.CreativeSpaceRe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.DialogCreativeSpace;
import view.FrmReportCreativeSpace;
import view.PanelButton;

/**
 *
 * @author Ricardo
 */
public class CreativeSpaceController implements KeyListener, ActionListener, MouseListener {

    private DialogCreativeSpace dialogCreativeSpace;
    private PanelButton panelButton;
    private FrmReportCreativeSpace reportCreativeSpace;
    private CreativeSpaceRe creativeSpaceRe;
    private int opt = 0;
    private CreativeSpace creativeSpaceSearch = null;

    public CreativeSpaceController() {
        this.reportCreativeSpace = new FrmReportCreativeSpace();
        this.creativeSpaceRe = new CreativeSpaceRe();
        
        this.reportCreativeSpace.setDataTable(this.creativeSpaceRe.getMatrix(), CreativeSpace.LABEL_CREATIVESPACES);

        this.reportCreativeSpace.listen(this);
        this.reportCreativeSpace.listener(this);

        this.dialogCreativeSpace = new DialogCreativeSpace(null, true);
        this.panelButton = this.reportCreativeSpace.getPanel();
        this.panelButton.setListen(this);
        this.dialogCreativeSpace.listener(this);
        
        

    }
    

    
    public boolean validation(CreativeSpace creativeSpace){
        if (creativeSpace.getId() == 0) {
            FrmReportCreativeSpace.setMessage("ID is Missing");
            System.out.println("ID miss");
            return false;
        }else if (creativeSpace.getCapacity()== 0) {
            FrmReportCreativeSpace.setMessage("Capacity is Missing");
            return false;
        }else if (creativeSpace.getLocation().isEmpty()) {
            FrmReportCreativeSpace.setMessage("Location is Missing");
            return false;
        }else if (creativeSpace.getName().isEmpty()) {
            FrmReportCreativeSpace.setMessage("Name is Missing");
            return false;
        }else if (creativeSpace.getPrice() == 0) {
            FrmReportCreativeSpace.setMessage("Price is Missing");
            return false;
        }else if(creativeSpace.getType().isEmpty()) {
            FrmReportCreativeSpace.setMessage("Type is Missing");
            return false;
        }else{
            return true;
        }
    }
    
    public FrmReportCreativeSpace getFrmReport(){
        return reportCreativeSpace;
    }
    
public CreativeSpaceRe getCreativeSpaceRe(){
    return this.creativeSpaceRe;
}

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.reportCreativeSpace.requestFocusInWindow();
        this.reportCreativeSpace.filterByID();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.reportCreativeSpace.requestFocusInWindow();

        switch (e.getActionCommand()) {
            case "Add":
                this.opt = 1;
                this.dialogCreativeSpace.setVisible(true);

                break;

            case "Edit":
                this.opt = 2;
                this.dialogCreativeSpace.setCreativeSpace(creativeSpaceSearch);
                this.dialogCreativeSpace.setVisible(true);

                break;

            case "Delete":
                if (creativeSpaceSearch!=null) {
                    FrmReportCreativeSpace.setMessage(this.creativeSpaceRe.delete(creativeSpaceSearch.getId()));
                    this.reportCreativeSpace.setDataTable(this.creativeSpaceRe.getMatrix(), CreativeSpace.LABEL_CREATIVESPACES);
                    this.creativeSpaceSearch = null;
                }
                
                break;
            case "Close":
                this.reportCreativeSpace.dispose();
                
                break;
                
            case "Ok":
              //  if (this.validation(this.dialogCreativeSpace.getCreativeSpace())) {
                    if (opt == 1) {
                        FrmReportCreativeSpace.setMessage(this.creativeSpaceRe.add(this.dialogCreativeSpace.getCreativeSpace()));
                        this.dialogCreativeSpace.clean();
                        
                    }else{
                        FrmReportCreativeSpace.setMessage(this.creativeSpaceRe.edit(this.dialogCreativeSpace.getCreativeSpace()));
                        this.dialogCreativeSpace.clean();
                        this.dialogCreativeSpace.dispose();
                        
                    }
                    
            //    }
                this.creativeSpaceSearch = null;
                this.reportCreativeSpace.setDataTable(this.creativeSpaceRe.getMatrix(), CreativeSpace.LABEL_CREATIVESPACES);
                this.dialogCreativeSpace.setEnabledID(true);
                break;
                
            case "Cancel": 
                this.dialogCreativeSpace.clean();
                this.dialogCreativeSpace.setEnabledID(true);
                this.dialogCreativeSpace.dispose();
                this.creativeSpaceSearch = null;
                break;
                
            case "Search":
                this.dialogCreativeSpace.setCreativeSpace(this.creativeSpaceRe.searchById(Integer.parseInt(this.dialogCreativeSpace.getID())));
                this.dialogCreativeSpace.setEnabledID(true);
                break;
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {

        this.reportCreativeSpace.requestFocusInWindow();
        this.creativeSpaceSearch = new CreativeSpace();
        String[] creativeRow = this.reportCreativeSpace.getRowSelected();
        this.creativeSpaceSearch.setId(Integer.parseInt(creativeRow[0]));
        this.creativeSpaceSearch.setName(creativeRow[1]);
        this.creativeSpaceSearch.setType(creativeRow[2]);
        this.creativeSpaceSearch.setCapacity(Integer.parseInt(creativeRow[3]));
        this.creativeSpaceSearch.setPrice(Integer.parseInt(creativeRow[4]));
        this.creativeSpaceSearch.setLocation(creativeRow[5]);
                
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
