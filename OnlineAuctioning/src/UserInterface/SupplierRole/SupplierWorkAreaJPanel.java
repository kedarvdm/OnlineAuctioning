/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SupplierRole;

import Business.Business.EcoSystem;
import UserInterface.AdvertiserRole.*;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class SupplierWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdvertiserWorkAreaJPanel
     */
    private OrganizationDirectory organizationDirectory;
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    public SupplierWorkAreaJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory,EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.ecoSystem=ecoSystem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageOrganizationsJButton = new javax.swing.JButton();
        manageEmployeesJButton = new javax.swing.JButton();
        manageUserAccountsButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        manageOrganizationsJButton.setText("Manage Organizations");
        manageOrganizationsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationsJButtonActionPerformed(evt);
            }
        });

        manageEmployeesJButton.setText("Manage Employees");
        manageEmployeesJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeesJButtonActionPerformed(evt);
            }
        });

        manageUserAccountsButton.setText("Manage User Accounts");
        manageUserAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserAccountsButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Supplier Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(manageUserAccountsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageEmployeesJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageOrganizationsJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageOrganizationsJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageEmployeesJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageUserAccountsButton)
                .addContainerGap(552, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrganizationsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationsJButtonActionPerformed
        // TODO add your handling code here:
        ManageSupplierOrganizationsJPanel maojp = new ManageSupplierOrganizationsJPanel(userProcessContainer, organizationDirectory);
        userProcessContainer.add("ManageSupplierOrganizationsJPanel", maojp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationsJButtonActionPerformed

    private void manageEmployeesJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeesJButtonActionPerformed
        // TODO add your handling code here:
        ManageSupplierEmployeesJPanel maejp = new ManageSupplierEmployeesJPanel(userProcessContainer, organizationDirectory);
        userProcessContainer.add("ManageSupplierEmployeesJPanel", maejp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEmployeesJButtonActionPerformed

    private void manageUserAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserAccountsButtonActionPerformed
        // TODO add your handling code here:
        ManageSupplierUserAccountsJPanel mauajp = new ManageSupplierUserAccountsJPanel(userProcessContainer, organizationDirectory,ecoSystem);
        userProcessContainer.add("ManageSupplierUserAccountsJPanel", mauajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageUserAccountsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel16;
    private javax.swing.JButton manageEmployeesJButton;
    private javax.swing.JButton manageOrganizationsJButton;
    private javax.swing.JButton manageUserAccountsButton;
    // End of variables declaration//GEN-END:variables
}
