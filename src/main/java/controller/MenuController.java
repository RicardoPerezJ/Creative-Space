/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrmMenu;
import view.FrmReportCreativeSpace;

/**
 *
 * @author Ricardo
 */
public class MenuController implements ActionListener{
    private FrmMenu fm;
    private CreativeSpaceController creativeSpaceController;
    private UserController userController;


    public MenuController() {
        creativeSpaceController = new CreativeSpaceController();
        userController = new UserController();
        
        
        fm = new FrmMenu();
        
        
        fm.listenMenu(this);
        fm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Exit":
                System.exit(0);
                break;
                
                case "About": 
                    FrmReportCreativeSpace.setMessage("Hecho por Ricardo Perez Jimenez");
                    break;
                    
                case "User":
                    userController.getFrmReport().setVisible(true);
                    
                    break;
                    
                case "Creative":
                    creativeSpaceController.getFrmReport().setVisible(true);
        }
    }
    
    
    
}
