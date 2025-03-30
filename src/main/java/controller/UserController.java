/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.User;
import Model.UserRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.DialogUser;
import view.FrmMenu;
import view.FrmReport;
import view.FrmUser;
import view.PanelButton;

/**
 *
 * @author Ricardo
 */
public class UserController implements ActionListener, MouseListener, KeyListener {

    private DialogUser dialogUser;
    private PanelButton panelButton;
    private FrmReport frmReport;
    private UserRegister userRegister;
    private FrmMenu menu;
    private int option = 0;
    private User userSearch = null;

    public UserController() {
        this.userRegister = new UserRegister();
        this.frmReport = new FrmReport();
        this.menu = new FrmMenu();

        //Metodo encargadod e refrescar la tabla
        this.frmReport.setDataTable(this.userRegister.getMatrix(),
                User.LABEL_USERS);
        this.frmReport.listenKey(this);

        this.frmReport.listenMouse(this);

        this.dialogUser = new DialogUser(null, true);
        this.panelButton = this.frmReport.getPanelButton();
        this.panelButton.setListen(this);
        this.dialogUser.setListen(this);
        this.menu.listenMenu(this);
        
        this.menu.setVisible(true);
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.menu.requestFocusInWindow();
        switch (e.getActionCommand()) {
            case "Add":
                this.option = 1;
                this.dialogUser.setVisible(true);

                break;

            case "Edit":
                this.option = 2;
                if (userSearch != null) {
                    this.dialogUser.setUser(userSearch);
                    this.dialogUser.setVisible(true);
                }
                break;

            case "Delete":
                if (userSearch != null) {
                    FrmReport.setMessage(this.userRegister.delete(userSearch.getId()));
                    this.frmReport.setDataTable(this.userRegister.getMatrix(),
                            User.LABEL_USERS);
                    this.userSearch = null;
                }
                break;

            case "Report":

                break;

            case "Close":
                System.exit(0);
                break;

            case "Ok":
                //agregar
                if (this.validation(this.dialogUser.getUser())) {
                    if (option == 1) {
                        FrmReport.setMessage(this.userRegister.add(this.dialogUser.getUser()));
//                    System.out.print(this.userRegister.getAll());
                        this.dialogUser.clean();
//                    this.dialogUser.dispose();
                        //Dispose = Metodo que oculta la ventana

                        //editar
                    } else {
                        FrmReport.setMessage(this.userRegister.
                                edit(this.dialogUser.getUser()));
                        this.dialogUser.clean();
                        this.dialogUser.dispose();

                    }
                }
                this.userSearch = null;

                this.frmReport.setDataTable(this.userRegister.getMatrix(),
                        User.LABEL_USERS);

                this.dialogUser.setEnabledID(true);
//                System.out.println(this.dialogUser.getUser());
                break;

            case "Cancel":
                this.dialogUser.clean();
                this.dialogUser.setEnabledID(true);
                this.dialogUser.dispose();
                this.userSearch = null;

                break;

            case "Search":
                this.dialogUser.setUser(this.userRegister.
                        searchById(Integer.parseInt(this.dialogUser.getID())));
                this.dialogUser.setEnabledID(false);
                break;

            case "User":
                this.frmReport.setVisible(true);

                System.out.println("Escuchado");
                break;
                
                

        }

    }

    public boolean validation(User user) {
        if (user.getId() == 0) {
            FrmReport.setMessage("The ID is missing");
            return false;
        } else if (user.getName().isEmpty()) {
            FrmReport.setMessage("The name is missing");
            return false;
        } else if (user.getAge() == 0) {
            FrmReport.setMessage("The age is missing");
            return false;
        } else if (user.getEmail().isEmpty()) {
            FrmReport.setMessage("The email is missing");
            return false;
        } else if (user.getTelephone().isEmpty()) {
            FrmReport.setMessage("The telephone is missing");
            return false;
        } else if (user.getDepartment().equals("..........")) {
            FrmReport.setMessage("The department is missing");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.frmReport.requestFocusInWindow();
        this.userSearch = new User();
        String[] userRow = this.frmReport.getRowSelected();
        this.userSearch.setId(Integer.parseInt(userRow[0]));
        this.userSearch.setName(userRow[1]);
        this.userSearch.setAge(Integer.parseInt(userRow[2]));
        this.userSearch.setEmail(userRow[3]);
        this.userSearch.setTelephone(userRow[4]);
        this.userSearch.setDepartment(userRow[5]);
        //No estoy seguro de si sirve o no

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

    //////////////////key 
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.frmReport.requestFocusInWindow();
        this.frmReport.filterByID();
    }

}
