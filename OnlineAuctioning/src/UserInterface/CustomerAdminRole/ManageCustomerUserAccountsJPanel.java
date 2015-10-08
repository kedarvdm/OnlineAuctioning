/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerAdminRole;

import Business.Business.EcoSystem;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonam
 */
public class ManageCustomerUserAccountsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private EcoSystem ecoSystem;
    public ManageCustomerUserAccountsJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory,EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory=organizationDirectory;
        this.ecoSystem=ecoSystem;
        populateOrganizations();
    }
    
    private void populateOrganizations()
    {
        organizationsJComboBox.removeAllItems();
        //Populate Organizations
        for(Organization o:organizationDirectory.getOrganizationList())
        {
            organizationsJComboBox.addItem(o);
        }
    }

    private void refreshTable(Organization org) {
        DefaultTableModel dtm = (DefaultTableModel) userAccountJTable.getModel();
        dtm.setRowCount(0);

        for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
            Object row[] = new Object[4];

            row[0] = ua;
            row[1] = ua.getUsername();
            row[2] = ua.getRole();
            row[3] = ua.getIsActive();
            dtm.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userAccountJTable = new javax.swing.JTable();
        deleteJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        addUserAccountJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        enableDisableUserJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        organizationsJComboBox = new javax.swing.JComboBox();

        userAccountJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Person", "User Name", "Role", "Is Active?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userAccountJTable);

        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        addUserAccountJButton.setText("Add User Account");
        addUserAccountJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserAccountJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        enableDisableUserJButton.setText("Activate/De-activate User");
        enableDisableUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableDisableUserJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Customer User Account's");

        jLabel2.setText("Organization:");

        organizationsJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationsJComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(backJButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(addUserAccountJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(refreshJButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(enableDisableUserJButton)))
                            .addGap(18, 18, 18)
                            .addComponent(deleteJButton))
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(organizationsJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(337, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(organizationsJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshJButton)
                    .addComponent(deleteJButton)
                    .addComponent(enableDisableUserJButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(addUserAccountJButton))
                .addContainerGap(330, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        ((CardLayout) userProcessContainer.getLayout()).previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        Organization org= (Organization) organizationsJComboBox.getSelectedItem();
        if(org==null)
        {
            JOptionPane.showMessageDialog(this, "Please select an organization", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        refreshTable(org);
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void addUserAccountJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserAccountJButtonActionPerformed
        // TODO add your handling code here:
        AddCustomerUserAccountJPanel aeuajp = new AddCustomerUserAccountJPanel(userProcessContainer, organizationDirectory,ecoSystem);
        userProcessContainer.add("AddCustomerUserAccountJPanel", aeuajp);
        ((CardLayout) userProcessContainer.getLayout()).next(userProcessContainer);
    }//GEN-LAST:event_addUserAccountJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
        Organization org= (Organization) organizationsJComboBox.getSelectedItem();
        
        if(org==null)
        {
            JOptionPane.showMessageDialog(this, "Please select an organization", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int selectedRow = userAccountJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an User", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        UserAccount ua = (UserAccount) userAccountJTable.getValueAt(selectedRow, 0);
        int flag = JOptionPane.showConfirmDialog(this, "Are you sure want to remove this user?", "Warning", JOptionPane.YES_NO_OPTION);
        if (flag == 0) {
            org.getUserAccountDirectory().removeUserAccount(ua);
            System.out.println("User removed");
        }
        refreshTable(org);
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void enableDisableUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableDisableUserJButtonActionPerformed
        // TODO add your handling code here:
        Organization org= (Organization) organizationsJComboBox.getSelectedItem();
        if(org==null)
        {
            JOptionPane.showMessageDialog(this, "Please select an organization", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int selectedRow = userAccountJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an User", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int flag = JOptionPane.NO_OPTION;
        UserAccount ua = (UserAccount) userAccountJTable.getValueAt(selectedRow, 0);
        if (ua.getIsActive().equalsIgnoreCase("Yes")) {
            flag = JOptionPane.showConfirmDialog(this, "Are you sure want to de-activate this user?", "Warning", JOptionPane.YES_NO_OPTION);
            if (flag == JOptionPane.YES_OPTION) {
                ua.setIsActive("No");
                System.out.println(ua.getUsername()+" marked inactive");
            }
        } else if (ua.getIsActive().equalsIgnoreCase("No")) {
            flag = JOptionPane.showConfirmDialog(this, "Are you sure want to activate this user?", "Warning", JOptionPane.YES_NO_OPTION);
            if (flag == JOptionPane.YES_OPTION) {
                ua.setIsActive("Yes");
                System.out.println(ua.getUsername()+" marked active");
            }
        }
        refreshTable(org);
    }//GEN-LAST:event_enableDisableUserJButtonActionPerformed

    private void organizationsJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationsJComboBoxActionPerformed
        // TODO add your handling code here:
        Organization org= (Organization) organizationsJComboBox.getSelectedItem();
        if(org!=null)
        {
            refreshTable(org);
        }
    }//GEN-LAST:event_organizationsJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserAccountJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton enableDisableUserJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationsJComboBox;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable userAccountJTable;
    // End of variables declaration//GEN-END:variables
}
