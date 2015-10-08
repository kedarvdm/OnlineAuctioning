/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Publisher.AdSpaceManagerRole;

import Business.Publisher.AdSpace.AdSpace;
import Business.Utils.MyIntegerVerifier;
import Business.Utils.MyStringVerifier;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class ViewEditAdSpaceDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewImageAdvertisementJPanel
     */
    private JPanel userProcessContainer;
    private AdSpace adSpace;
    public ViewEditAdSpaceDetailsJPanel(JPanel userProcessContainer,AdSpace adSpace) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.adSpace=adSpace;
        setVerifiers();
        DisplayAdDetails();
    }
    private void setVerifiers()
    {
        MyStringVerifier myStringVerifier= new MyStringVerifier();
        titleJTextField.setInputVerifier(myStringVerifier);
        MyIntegerVerifier myIntegerVerifier= new MyIntegerVerifier();
        widthJTextField.setInputVerifier(myIntegerVerifier);
        heightJTextField.setInputVerifier(myIntegerVerifier);
        xAxisJTextField.setInputVerifier(myIntegerVerifier);
        yAxisJTextField.setInputVerifier(myIntegerVerifier);
    }
    private void DisplayAdDetails()
    {
        adSpaceIDJTextField.setText(String.valueOf(adSpace.getAdSpaceID()));
        titleJTextField.setText(adSpace.getTitle());
        xAxisJTextField.setText(String.valueOf(adSpace.getX()));
        yAxisJTextField.setText(String.valueOf(adSpace.getY()));
        widthJTextField.setText(String.valueOf(adSpace.getWidth()));
        heightJTextField.setText(String.valueOf(adSpace.getHeight()));
        dateCreatedJTextField.setText(adSpace.getDateCreated().toString());
        if(adSpace.isReady())
        {
            isReadyYesJRadioButton.setSelected(true);
            isReadyNoJRadioButton.setSelected(false);
        }
        else
        {
            isReadyYesJRadioButton.setSelected(false);
            isReadyNoJRadioButton.setSelected(true);
        }
        
        if(adSpace.isEnabled())
        {
            isEnabledYesJRadioButton.setSelected(true);
            isEnabledNoJRadioButton.setSelected(false);
        }
        else
        {
            isEnabledYesJRadioButton.setSelected(false);
            isEnabledNoJRadioButton.setSelected(true);
        }
        notesJTextField.setText(adSpace.getNotes());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        adSpaceIDJTextField = new javax.swing.JTextField();
        titleJTextField = new javax.swing.JTextField();
        xAxisJTextField = new javax.swing.JTextField();
        widthJTextField = new javax.swing.JTextField();
        heightJTextField = new javax.swing.JTextField();
        yAxisJTextField = new javax.swing.JTextField();
        dateCreatedJTextField = new javax.swing.JTextField();
        notesJTextField = new javax.swing.JTextField();
        isReadyNoJRadioButton = new javax.swing.JRadioButton();
        isReadyYesJRadioButton = new javax.swing.JRadioButton();
        isEnabledYesJRadioButton = new javax.swing.JRadioButton();
        isEnabledNoJRadioButton = new javax.swing.JRadioButton();
        backJButton1 = new javax.swing.JButton();
        updateJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        jLabel1.setText("Ad Space ID:");

        jLabel2.setText("Title:");

        jLabel3.setText("X:");

        jLabel4.setText("Width:");

        jLabel5.setText("Height:");

        jLabel7.setText("Date Created:");

        jLabel8.setText("Ready?:");

        jLabel9.setText("Enabled?:");

        jLabel10.setText("Notes:");

        jLabel12.setText("Y:");

        adSpaceIDJTextField.setEnabled(false);

        titleJTextField.setEnabled(false);

        xAxisJTextField.setEnabled(false);

        widthJTextField.setEnabled(false);

        heightJTextField.setEnabled(false);

        yAxisJTextField.setEnabled(false);

        dateCreatedJTextField.setEnabled(false);

        notesJTextField.setEnabled(false);

        isReadyNoJRadioButton.setText("No");
        isReadyNoJRadioButton.setEnabled(false);

        isReadyYesJRadioButton.setSelected(true);
        isReadyYesJRadioButton.setText("Yes");
        isReadyYesJRadioButton.setEnabled(false);

        isEnabledYesJRadioButton.setSelected(true);
        isEnabledYesJRadioButton.setText("Yes");
        isEnabledYesJRadioButton.setEnabled(false);

        isEnabledNoJRadioButton.setText("No");
        isEnabledNoJRadioButton.setEnabled(false);

        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });

        saveJButton.setText("Save");
        saveJButton.setEnabled(false);
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("View/Edit Advertisement Space");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yAxisJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateCreatedJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(heightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(widthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xAxisJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adSpaceIDJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(isReadyYesJRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isReadyNoJRadioButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(isEnabledYesJRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isEnabledNoJRadioButton))))
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(667, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(adSpaceIDJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(xAxisJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(yAxisJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(widthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(heightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateCreatedJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(isReadyYesJRadioButton)
                        .addComponent(isReadyNoJRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(isEnabledYesJRadioButton)
                    .addComponent(isEnabledNoJRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(notesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(updateJButton)
                    .addComponent(saveJButton))
                .addContainerGap(223, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        ((CardLayout) userProcessContainer.getLayout()).previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        // TODO add your handling code here:
        titleJTextField.setEnabled(true);
        xAxisJTextField.setEnabled(true);
        yAxisJTextField.setEnabled(true);
        widthJTextField.setEnabled(true);
        heightJTextField.setEnabled(true);
        isReadyYesJRadioButton.setEnabled(true);
        isReadyNoJRadioButton.setEnabled(true);
        isEnabledYesJRadioButton.setEnabled(true);
        isEnabledNoJRadioButton.setEnabled(true);
        notesJTextField.setEnabled(true);
        updateJButton.setEnabled(false);
        saveJButton.setEnabled(true);
    }//GEN-LAST:event_updateJButtonActionPerformed

    private Boolean validateFields()
    {
        if(titleJTextField.getText().length()==0
                || xAxisJTextField.getText().length()==0
                || yAxisJTextField.getText().length()==0
                || widthJTextField.getText().length()==0
                || heightJTextField.getText().length()==0)
        {
            return false;
        }
        return true;
    }
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        // TODO add your handling code here:
        if(!validateFields())
        {
            JOptionPane.showMessageDialog(this,"Please enter correct fields","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        adSpace.setTitle(titleJTextField.getText());
        adSpace.setX(Integer.parseInt(xAxisJTextField.getText()));
        adSpace.setY(Integer.parseInt(yAxisJTextField.getText()));
        adSpace.setWidth(Integer.parseInt(widthJTextField.getText()));
        adSpace.setHeight(Integer.parseInt(heightJTextField.getText()));
        if(isReadyYesJRadioButton.isSelected())
        {
            adSpace.setReady(true);
        }
        else if(isReadyNoJRadioButton.isSelected())
        {
            adSpace.setReady(false);
        }
        
        if(isEnabledYesJRadioButton.isSelected())
        {
            adSpace.setEnabled(true);
        }
        else if(isEnabledNoJRadioButton.isSelected())
        {
            adSpace.setEnabled(false);
        }
        adSpace.setNotes(notesJTextField.getText());
        JOptionPane.showMessageDialog(this,"Ad Space updated!!","Update",JOptionPane.INFORMATION_MESSAGE);
        saveJButton.setEnabled(false);
        updateJButton.setEnabled(true);
        titleJTextField.setEnabled(false);
        xAxisJTextField.setEnabled(false);
        yAxisJTextField.setEnabled(false);
        widthJTextField.setEnabled(false);
        heightJTextField.setEnabled(false);
        isReadyYesJRadioButton.setEnabled(false);
        isReadyNoJRadioButton.setEnabled(false);
        isEnabledYesJRadioButton.setEnabled(false);
        isEnabledNoJRadioButton.setEnabled(false);
        notesJTextField.setEnabled(false);
    }//GEN-LAST:event_saveJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adSpaceIDJTextField;
    private javax.swing.JButton backJButton1;
    private javax.swing.JTextField dateCreatedJTextField;
    private javax.swing.JTextField heightJTextField;
    private javax.swing.JRadioButton isEnabledNoJRadioButton;
    private javax.swing.JRadioButton isEnabledYesJRadioButton;
    private javax.swing.JRadioButton isReadyNoJRadioButton;
    private javax.swing.JRadioButton isReadyYesJRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField notesJTextField;
    private javax.swing.JButton saveJButton;
    private javax.swing.JTextField titleJTextField;
    private javax.swing.JButton updateJButton;
    private javax.swing.JTextField widthJTextField;
    private javax.swing.JTextField xAxisJTextField;
    private javax.swing.JTextField yAxisJTextField;
    // End of variables declaration//GEN-END:variables
}
