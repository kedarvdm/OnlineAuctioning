/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Publisher.AdSpaceCreatorRole;

import Business.Publisher.AdSpace.AdSpace;
import Business.Publisher.WorkRequests.AdSpaceCreationWorkRequest;
import Business.Utils.MyIntegerVerifier;
import Business.Utils.MyStringVerifier;
import UserInterface.Publisher.AdSpaceManagerRole.ViewAdSpaceJPanel;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class ProcessAdSpaceCreationRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProcessAdCreationRequestJPanel
     */
    private JPanel userProcessContainer;
    private AdSpaceCreationWorkRequest myWorkRequest;
    private AdSpace adSpace;
    public ProcessAdSpaceCreationRequestJPanel(JPanel userProcessContainer,AdSpaceCreationWorkRequest myWorkRequest) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.myWorkRequest=myWorkRequest;
        this.adSpace=this.myWorkRequest.getAdSpace();
        setVerifiers();
        populateAdSpaceDetails();
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
    private void populateAdSpaceDetails()
    {
        titleJTextField.setText(adSpace.getTitle());
        if(adSpace.getX()!=0)
        {    
            xAxisJTextField.setText(String.valueOf(adSpace.getX()));
        }
        if(adSpace.getY()!=0)
        {
            yAxisJTextField.setText(String.valueOf(adSpace.getY()));
        }
        if(adSpace.getWidth()!=0)
        {    
            widthJTextField.setText(String.valueOf(adSpace.getWidth()));
        }
        if(adSpace.getHeight()!=0)
        {
            heightJTextField.setText(String.valueOf(adSpace.getHeight()));
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

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titleJTextField = new javax.swing.JTextField();
        widthJTextField = new javax.swing.JTextField();
        heightJTextField = new javax.swing.JTextField();
        saveAdSpaceJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        xAxisJTextField = new javax.swing.JTextField();
        yAxisJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        notesJTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        viewAdSpaceJButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setText("Title:");

        jLabel2.setText("Width:");

        jLabel3.setText("Height:");

        saveAdSpaceJButton.setText("Save Ad Space");
        saveAdSpaceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAdSpaceJButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("X:");

        jLabel6.setText("Y:");

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Notes:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Create Ad Space");

        viewAdSpaceJButton.setText("View Ad Space");
        viewAdSpaceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdSpaceJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(backJButton)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(titleJTextField)
                                .addComponent(widthJTextField)
                                .addComponent(heightJTextField)
                                .addComponent(xAxisJTextField)
                                .addComponent(yAxisJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addComponent(notesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveAdSpaceJButton)
                                .addGap(18, 18, 18)
                                .addComponent(viewAdSpaceJButton)))))
                .addContainerGap(490, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(xAxisJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(yAxisJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(widthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(heightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(notesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveAdSpaceJButton)
                    .addComponent(backJButton)
                    .addComponent(viewAdSpaceJButton))
                .addContainerGap(404, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveAdSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAdSpaceJButtonActionPerformed
        // TODO add your handling code here:
        if(!validateFields())
        {
            JOptionPane.showMessageDialog(this,"Please enter correct values","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        adSpace.setTitle(titleJTextField.getText());
        adSpace.setX(Integer.parseInt(xAxisJTextField.getText()));
        adSpace.setY(Integer.parseInt(yAxisJTextField.getText()));
        adSpace.setWidth(Integer.parseInt(widthJTextField.getText()));
        adSpace.setHeight(Integer.parseInt(heightJTextField.getText()));
        adSpace.setNotes(notesJTextField.getText());
        adSpace.setDateCreated(new Date());
        
        myWorkRequest.setResolveDate(new Date());
        myWorkRequest.setStatus("Completed");
        System.out.println("Ad Space created/updated");
        JOptionPane.showMessageDialog(this,"Ad Space created/updated","Update",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveAdSpaceJButtonActionPerformed

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
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewAdSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdSpaceJButtonActionPerformed
        // TODO add your handling code here:
        if(!myWorkRequest.getStatus().equals("Completed"))
        {
            JOptionPane.showMessageDialog(this,"Please save the Ad Space first.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        AdSpace adSpace= myWorkRequest.getAdSpace();

        ViewAdSpaceJPanel vasjp = new ViewAdSpaceJPanel(userProcessContainer,adSpace);
        userProcessContainer.add("ViewAdSpaceJPanel", vasjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdSpaceJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField heightJTextField;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField notesJTextField;
    private javax.swing.JButton saveAdSpaceJButton;
    private javax.swing.JTextField titleJTextField;
    private javax.swing.JButton viewAdSpaceJButton;
    private javax.swing.JTextField widthJTextField;
    private javax.swing.JTextField xAxisJTextField;
    private javax.swing.JTextField yAxisJTextField;
    // End of variables declaration//GEN-END:variables
}