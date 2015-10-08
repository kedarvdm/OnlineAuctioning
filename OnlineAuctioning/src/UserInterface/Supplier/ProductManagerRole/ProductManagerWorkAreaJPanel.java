/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier.ProductManagerRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class ProductManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SupplierWorkAreaJPanel1
     */
    private JPanel userProcessContainer;
    private UserAccount ua;
    private Enterprise enterprise;
    public ProductManagerWorkAreaJPanel(JPanel upc,Enterprise enterprise,UserAccount ua) {
        initComponents();
        this.userProcessContainer = upc;
        this.ua=ua;
        this.enterprise=enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageProductCatalogJButton = new javax.swing.JButton();
        reviewPerformanceJButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        manageProductCatalogJButton.setText("Manage Product Catalog");
        manageProductCatalogJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProductCatalogJButtonActionPerformed(evt);
            }
        });

        reviewPerformanceJButton.setText("Review Performance");
        reviewPerformanceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewPerformanceJButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Product Manager Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(reviewPerformanceJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageProductCatalogJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageProductCatalogJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reviewPerformanceJButton)
                .addContainerGap(380, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageProductCatalogJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProductCatalogJButtonActionPerformed
        // TODO add your handling code here:
        ManageProductCatalogJPanel mpcjp = new ManageProductCatalogJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("ManageProductCatalogJPanel",mpcjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageProductCatalogJButtonActionPerformed

    private void reviewPerformanceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewPerformanceJButtonActionPerformed
        // TODO add your handling code here:
        ViewSupplierPerformanceJPanel vspjp = new ViewSupplierPerformanceJPanel(userProcessContainer, (SupplierEnterprise)enterprise);
        userProcessContainer.add("ViewSupplierPerformanceJPanel",vspjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_reviewPerformanceJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel16;
    private javax.swing.JButton manageProductCatalogJButton;
    private javax.swing.JButton reviewPerformanceJButton;
    // End of variables declaration//GEN-END:variables
}
