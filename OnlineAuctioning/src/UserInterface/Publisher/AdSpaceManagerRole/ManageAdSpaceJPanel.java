/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Publisher.AdSpaceManagerRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.PublisherEnterprise;
import Business.Publisher.AdSpace.AdSpace;
import Business.Publisher.ServerSidePlatform.SSP;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonam
 */
public class ManageAdSpaceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageAdInventoryJPanel
     */
    private JPanel userProcessContainer;
    private PublisherEnterprise publisherEnterprise;
    private UserAccount userAccount;
    public ManageAdSpaceJPanel(JPanel userProcessContainer,Enterprise enterprise,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.publisherEnterprise= (PublisherEnterprise)enterprise;
        this.userAccount=userAccount;
        populateAdSpaceInventory();
    }
    
    private void populateAdSpaceInventory()
    {
        DefaultTableModel dtm= (DefaultTableModel) adSpaceInventoryJTable.getModel();
        dtm.setRowCount(0);

        for (AdSpace adSpace : publisherEnterprise.getAdSpaceInventory().getAdSpaceList()) {
            if (adSpace.isReady()) 
            {
                Object row[] = new Object[5];

                row[0] = adSpace.getAdSpaceID();
                row[1] = adSpace;
                row[2] = adSpace.getDateCreated();
                row[3] = adSpace.isEnabled()== Boolean.TRUE ?  "Yes":"No";
                row[4] = adSpace.getNotes();
                dtm.addRow(row);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adSpaceInventoryJTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();
        viewAdSpaceDetailsJButton = new javax.swing.JButton();
        enableDisableAdSpaceJButton = new javax.swing.JButton();
        removeAdSpaceJButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        viewAdSpaceJButton = new javax.swing.JButton();

        jLabel1.setText("Ad Space Inventory:");

        adSpaceInventoryJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ad Space ID", "Title", "Date Created", "Enabled?", "Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(adSpaceInventoryJTable);

        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        viewAdSpaceDetailsJButton.setText("View/Edit Ad Space Detils");
        viewAdSpaceDetailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdSpaceDetailsJButtonActionPerformed(evt);
            }
        });

        enableDisableAdSpaceJButton.setText("Enable/Disable Ad Space");
        enableDisableAdSpaceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableDisableAdSpaceJButtonActionPerformed(evt);
            }
        });

        removeAdSpaceJButton.setText("Remove Ad Space");
        removeAdSpaceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAdSpaceJButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Manage Ad Space Inventory");

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
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(backJButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewAdSpaceDetailsJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enableDisableAdSpaceJButton)
                        .addGap(17, 17, 17)
                        .addComponent(removeAdSpaceJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewAdSpaceJButton)))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(viewAdSpaceDetailsJButton)
                    .addComponent(enableDisableAdSpaceJButton)
                    .addComponent(removeAdSpaceJButton)
                    .addComponent(viewAdSpaceJButton))
                .addContainerGap(430, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        ((CardLayout) userProcessContainer.getLayout()).previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void enableDisableAdSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableDisableAdSpaceJButtonActionPerformed
        // TODO add your handling code here:
        int flag;
        int selectedRow = adSpaceInventoryJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Ad Space.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdSpace adSpace= (AdSpace) adSpaceInventoryJTable.getValueAt(selectedRow, 1);
        
        if(adSpace.isEnabled()==true)
        {
            flag = JOptionPane.showConfirmDialog(this, "Are you sure want to disable this Ad Space?", "Warning", JOptionPane.YES_NO_OPTION);
            if (flag == JOptionPane.YES_OPTION) {
                adSpace.setEnabled(false);
                System.out.println("Ad Space disabled");
            }
        }else if(adSpace.isEnabled()==false)
        {
            flag = JOptionPane.showConfirmDialog(this, "Are you sure want to enable this Ad Space?", "Warning", JOptionPane.YES_NO_OPTION);
            if (flag == JOptionPane.YES_OPTION) {
                adSpace.setEnabled(true);
                System.out.println("Ad Space enabled");
            }
        }
        populateAdSpaceInventory();
    }//GEN-LAST:event_enableDisableAdSpaceJButtonActionPerformed

    private void removeAdSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAdSpaceJButtonActionPerformed
        // TODO add your handling code here:
        int flag;
        int selectedRow = adSpaceInventoryJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Ad Space.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdSpace adSpace= (AdSpace) adSpaceInventoryJTable.getValueAt(selectedRow, 1);
        
        flag = JOptionPane.showConfirmDialog(this, "All the SSP's will be removed for this Ad Space. Are you sure want to remove this Ad Space?", "Warning", JOptionPane.YES_NO_OPTION);
        if (flag == JOptionPane.YES_OPTION) {
            //Remove SSP's first
            for(SSP ssp: publisherEnterprise.getSSPDirectory().getSspList())
            {
                if(ssp.getAdSpace()==adSpace)
                {
                    publisherEnterprise.getSSPDirectory().removeSSP(ssp);

                }
            }
            System.out.println("SSP's Removed");
            //Delete the Ad Space
            publisherEnterprise.getAdSpaceInventory().removeAdpace(adSpace);
            System.out.println("Ad Space Removed");
        }
        populateAdSpaceInventory();
    }//GEN-LAST:event_removeAdSpaceJButtonActionPerformed

    private void viewAdSpaceDetailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdSpaceDetailsJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = adSpaceInventoryJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Ad Space.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdSpace adSpace= (AdSpace) adSpaceInventoryJTable.getValueAt(selectedRow, 1);
        
        ViewEditAdSpaceDetailsJPanel vasdjp = new ViewEditAdSpaceDetailsJPanel(userProcessContainer,adSpace);
        userProcessContainer.add("ViewAdSpaceDetailsJPanel", vasdjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_viewAdSpaceDetailsJButtonActionPerformed

    private void viewAdSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdSpaceJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = adSpaceInventoryJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Ad Space.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        AdSpace adSpace= (AdSpace) adSpaceInventoryJTable.getValueAt(selectedRow, 1);
        
        ViewAdSpaceJPanel vasjp = new ViewAdSpaceJPanel(userProcessContainer,adSpace);
        userProcessContainer.add("ViewAdSpaceJPanel", vasjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdSpaceJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adSpaceInventoryJTable;
    private javax.swing.JButton backJButton1;
    private javax.swing.JButton enableDisableAdSpaceJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeAdSpaceJButton;
    private javax.swing.JButton viewAdSpaceDetailsJButton;
    private javax.swing.JButton viewAdSpaceJButton;
    // End of variables declaration//GEN-END:variables
}