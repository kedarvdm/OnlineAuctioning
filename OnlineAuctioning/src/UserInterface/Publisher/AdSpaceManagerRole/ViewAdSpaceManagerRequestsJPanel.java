/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Publisher.AdSpaceManagerRole;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Publisher.AdSpace.AdSpace;
import Business.Publisher.WorkRequests.AdSpaceCreationWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonam
 */
public class ViewAdSpaceManagerRequestsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAdInventoryManagerRequestsJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private UserAccount userAccount;
    public ViewAdSpaceManagerRequestsJPanel(JPanel userProcessContainer,Organization organization,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.organization=organization;
        this.userAccount=userAccount;
        populateMyRequestsTable();
    }
    private void populateMyRequestsTable()
    {
        DefaultTableModel dtm= (DefaultTableModel) myAdSpaceRequestsTable.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof AdSpaceCreationWorkRequest) {
                Object row[] = new Object[9];

                row[0] = request;
                row[1] = request.getSender();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getPerson().getName();
                row[3] = request.getStatus();
                row[4] = request.getRequestDate();
                row[5] = request.getResolveDate();
                row[6] = ((AdSpaceCreationWorkRequest)request).getAdSpace();
                row[7] = ((AdSpaceCreationWorkRequest)request).getAdSpace().isReady()== Boolean.TRUE? "Yes":"No";
                row[8] = ((AdSpaceCreationWorkRequest)request).getAdSpace().isEnabled()== Boolean.TRUE? "Yes":"No";
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
        myAdSpaceRequestsTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();
        markAdReadyJButton = new javax.swing.JButton();
        markAdEnabledJButton = new javax.swing.JButton();
        viewAdSpaceDetailsJButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        viewAdSpaceJButton = new javax.swing.JButton();

        jLabel1.setText("My Ad Space Requests:");

        myAdSpaceRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Request Date", "Resolve Date", "Ad Space", "Ready?", "Enabled?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(myAdSpaceRequestsTable);

        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        markAdReadyJButton.setText("Mark Ready");
        markAdReadyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAdReadyJButtonActionPerformed(evt);
            }
        });

        markAdEnabledJButton.setText("Mark Enabled");
        markAdEnabledJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAdEnabledJButtonActionPerformed(evt);
            }
        });

        viewAdSpaceDetailsJButton.setText("View/Edit Ad Space Detils");
        viewAdSpaceDetailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdSpaceDetailsJButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Ad Space Manager Requests");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewAdSpaceDetailsJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(markAdReadyJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(markAdEnabledJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewAdSpaceJButton)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(markAdReadyJButton)
                    .addComponent(markAdEnabledJButton)
                    .addComponent(viewAdSpaceDetailsJButton)
                    .addComponent(viewAdSpaceJButton))
                .addContainerGap(488, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        ((CardLayout) userProcessContainer.getLayout()).previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void markAdReadyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAdReadyJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = myAdSpaceRequestsTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdSpaceCreationWorkRequest myWorkRequest = (AdSpaceCreationWorkRequest) myAdSpaceRequestsTable.getValueAt(selectedRow, 0);
        
        AdSpace adSpace= myWorkRequest.getAdSpace();
        
        if(adSpace.isReady())
        {
            JOptionPane.showMessageDialog(this,"Ad Space is already marked Ready","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!(myWorkRequest.getStatus().equals("Completed")))
        {
            JOptionPane.showMessageDialog(this,"Ad Space is not ready yet","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        adSpace.setReady(true);
        System.out.println("Ad Space marked ready");
        populateMyRequestsTable();
    }//GEN-LAST:event_markAdReadyJButtonActionPerformed

    private void markAdEnabledJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAdEnabledJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = myAdSpaceRequestsTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdSpaceCreationWorkRequest myWorkRequest = (AdSpaceCreationWorkRequest) myAdSpaceRequestsTable.getValueAt(selectedRow, 0);
        
        AdSpace adSpace= myWorkRequest.getAdSpace();
        
        if(adSpace.isEnabled())
        {
            JOptionPane.showMessageDialog(this,"Ad Space is already marked Enabled","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!(myWorkRequest.getStatus().equals("Completed")))
        {
            JOptionPane.showMessageDialog(this,"Ad Space is not ready yet","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!adSpace.isReady() && (myWorkRequest.getStatus().equals("Completed")))
        {
            JOptionPane.showMessageDialog(this,"Please mark Ad Space as Ready first.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        adSpace.setEnabled(true);
        System.out.println("Ad Space marked enabled");
        populateMyRequestsTable();
    }//GEN-LAST:event_markAdEnabledJButtonActionPerformed

    private void viewAdSpaceDetailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdSpaceDetailsJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = myAdSpaceRequestsTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdSpaceCreationWorkRequest myWorkRequest = (AdSpaceCreationWorkRequest) myAdSpaceRequestsTable.getValueAt(selectedRow, 0);
        
        if(!myWorkRequest.getStatus().equals("Completed"))
        {
            JOptionPane.showMessageDialog(this, "Ad Space is not ready yet.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        AdSpace adSpace= myWorkRequest.getAdSpace();

        ViewEditAdSpaceDetailsJPanel vasdjp = new ViewEditAdSpaceDetailsJPanel(userProcessContainer,adSpace);
        userProcessContainer.add("ViewAdSpaceDetailsJPanel", vasdjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_viewAdSpaceDetailsJButtonActionPerformed

    private void viewAdSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdSpaceJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = myAdSpaceRequestsTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdSpaceCreationWorkRequest myWorkRequest = (AdSpaceCreationWorkRequest) myAdSpaceRequestsTable.getValueAt(selectedRow, 0);
        
        if(!myWorkRequest.getStatus().equals("Completed"))
        {
            JOptionPane.showMessageDialog(this, "Ad Space is not ready yet.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        AdSpace adSpace= myWorkRequest.getAdSpace();

        ViewAdSpaceJPanel vasjp = new ViewAdSpaceJPanel(userProcessContainer,adSpace);
        userProcessContainer.add("ViewAdSpaceJPanel", vasjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdSpaceJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton markAdEnabledJButton;
    private javax.swing.JButton markAdReadyJButton;
    private javax.swing.JTable myAdSpaceRequestsTable;
    private javax.swing.JButton viewAdSpaceDetailsJButton;
    private javax.swing.JButton viewAdSpaceJButton;
    // End of variables declaration//GEN-END:variables
}
