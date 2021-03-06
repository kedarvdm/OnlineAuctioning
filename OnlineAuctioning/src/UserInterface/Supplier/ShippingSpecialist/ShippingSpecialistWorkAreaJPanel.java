/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Supplier.ShippingSpecialist;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Guest
 */
public class ShippingSpecialistWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private UserAccount ua;
    public ShippingSpecialistWorkAreaJPanel(JPanel userProcessContainer,UserAccount ua, Organization organization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.ua=ua;
        this.organization=organization;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageShippingRequestsJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        manageShippingRequestsJButton.setText("Manage Shipping Requests");
        manageShippingRequestsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageShippingRequestsJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Shipping Specialist Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(manageShippingRequestsJButton))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(manageShippingRequestsJButton)
                .addContainerGap(224, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageShippingRequestsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageShippingRequestsJButtonActionPerformed
        // TODO add your handling code here:
        ManageShippingRequestsJPanel msrjp= new ManageShippingRequestsJPanel(userProcessContainer,organization, ua);
        userProcessContainer.add("ManageShippingRequestsJPanel", msrjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageShippingRequestsJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageShippingRequestsJButton;
    // End of variables declaration//GEN-END:variables
}
