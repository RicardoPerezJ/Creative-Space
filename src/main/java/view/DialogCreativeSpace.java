/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import Model.CreativeSpace;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author Ricardo
 */
public class DialogCreativeSpace extends javax.swing.JDialog {

    /**
     * Creates new form DialogCreativeSpaces
     */
    public DialogCreativeSpace(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CreativeSpace getCreativeSpace (){
        CreativeSpace creativeSpace = new CreativeSpace();
        
        creativeSpace.setId(Integer.parseInt(this.txtFID.getText().toString()));
        creativeSpace.setName(this.txtFName.getText().toString());
        creativeSpace.setType(this.txtFType.getText().toString());
        creativeSpace.setCapacity(Integer.parseInt(this.txtFCapacity.getText()));
        creativeSpace.setPrice(Integer.parseInt(this.txtFPrice.getText().toString()));
        creativeSpace.setLocation(this.txtFLocation.getText().toString());
        
        return creativeSpace;
    }
    
    public void setCreativeSpace (CreativeSpace creativeSpace){
        this.txtFID.setText(String.valueOf(creativeSpace.getId()));
        this.txtFName.setText(creativeSpace.getName());
        this.txtFType.setText(creativeSpace.getType());
        this.txtFCapacity.setText(String.valueOf(creativeSpace.getCapacity()));
        this.txtFPrice.setText(String.valueOf(creativeSpace.getPrice()));
        this.txtFLocation.setText(creativeSpace.getLocation());
        
    }

    public void clean() {
        this.txtFCapacity.setText("");
        this.txtFID.setText("");
        this.txtFLocation.setText("");
        this.txtFName.setText("");
        this.txtFPrice.setText("");
        this.txtFType.setText("");
    }
    
    
        public String getID(){
        return this.txtFID.getText();
    }
    
        public void setEnabledID(boolean option) {
        this.txtFID.setEnabled(option);
    }


    
    
        public void listener (ActionListener listener){
        this.jBtnOk.addActionListener(listener);
        this.jBtnCancel.addActionListener(listener);
    }
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFID = new javax.swing.JTextField();
        txtFLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        jBtnOk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBtnCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFType = new javax.swing.JTextField();
        txtFCapacity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtFID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFIDActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        jBtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        jBtnOk.setActionCommand("Ok");
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        jLabel3.setText("Name:");

        jBtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/multiply.png"))); // NOI18N
        jBtnCancel.setActionCommand("Cancel");
        jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Type:");

        jLabel5.setText("Capacity:");

        jLabel6.setText("Price:");

        jLabel7.setText("Location:");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Creative Space Register");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFName)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFID)
                    .addComponent(txtFType)
                    .addComponent(txtFCapacity)
                    .addComponent(txtFPrice)
                    .addComponent(txtFLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnOk)
                .addGap(18, 18, 18)
                .addComponent(jBtnCancel)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnCancel)
                            .addComponent(jBtnOk))
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFIDActionPerformed

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnOkActionPerformed

    private void jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCancelActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtFCapacity;
    private javax.swing.JTextField txtFID;
    private javax.swing.JTextField txtFLocation;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtFPrice;
    private javax.swing.JTextField txtFType;
    // End of variables declaration//GEN-END:variables
}
