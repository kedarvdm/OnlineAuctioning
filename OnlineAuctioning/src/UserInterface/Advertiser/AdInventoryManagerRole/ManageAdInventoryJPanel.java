/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Advertiser.AdInventoryManagerRole;

import Business.Advertiser.Advertisement.Advertisement;
import Business.Advertiser.DemandSidePlatform.DSP;
import Business.Enterprise.AdvertiserEnterprise;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonam
 */
public class ManageAdInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageAdInventoryJPanel
     */
    private JPanel userProcessContainer;
    private AdvertiserEnterprise adEnterprise;
    private UserAccount userAccount;
    public ManageAdInventoryJPanel(JPanel userProcessContainer,Enterprise enterprise,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.adEnterprise= (AdvertiserEnterprise)enterprise;
        this.userAccount=userAccount;
        populateAdInventory();
    }
    
    private void populateAdInventory()
    {
        DefaultTableModel dtm= (DefaultTableModel) adInventoryJTable.getModel();
        dtm.setRowCount(0);

        for (Advertisement advertisement : adEnterprise.getAdInventory().getAdvertimentsList()) {
            if (advertisement.isReady()) 
            {
                Object row[] = new Object[4];

                row[0] = advertisement.getAdvertisementID();
                row[1] = advertisement;
                row[2] = advertisement.getDateCreated();
                row[3] = advertisement.isEnabled()== Boolean.TRUE ?  "Yes":"No";
                
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
        adInventoryJTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();
        viewAdJButton = new javax.swing.JButton();
        enableDisableAdJButton = new javax.swing.JButton();
        removeAdJButton = new javax.swing.JButton();
        viewAdvertisementJJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("Ad Inventory:");

        adInventoryJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ad ID", "Title", "Date Created", "Enabled?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(adInventoryJTable);

        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        viewAdJButton.setText("View/Edit Ad Detils");
        viewAdJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdJButtonActionPerformed(evt);
            }
        });

        enableDisableAdJButton.setText("Enable/Disable Ad");
        enableDisableAdJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableDisableAdJButtonActionPerformed(evt);
            }
        });

        removeAdJButton.setText("Remove Ad");
        removeAdJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAdJButtonActionPerformed(evt);
            }
        });

        viewAdvertisementJJButton.setText("View Advertisement");
        viewAdvertisementJJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdvertisementJJButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Manage Ad Inventory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewAdJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enableDisableAdJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeAdJButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewAdvertisementJJButton))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(viewAdJButton)
                    .addComponent(enableDisableAdJButton)
                    .addComponent(removeAdJButton)
                    .addComponent(viewAdvertisementJJButton))
                .addContainerGap(426, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        ((CardLayout) userProcessContainer.getLayout()).previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void viewAdvertisementJJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdvertisementJJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = adInventoryJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Advertisement.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Advertisement advertisement= (Advertisement) adInventoryJTable.getValueAt(selectedRow, 1);
        if(!advertisement.isReady())
        {
            JOptionPane.showMessageDialog(this, "Advertisement not ready yet.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ViewAdvertisementJPanel vijp = new ViewAdvertisementJPanel(userProcessContainer,advertisement);
        userProcessContainer.add("ViewImageJPanel", vijp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdvertisementJJButtonActionPerformed

    private void enableDisableAdJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableDisableAdJButtonActionPerformed
        // TODO add your handling code here:
        int flag;
        int selectedRow = adInventoryJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Advertisement.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Advertisement advertisement= (Advertisement) adInventoryJTable.getValueAt(selectedRow, 1);
        
        if(!advertisement.isReady())
        {
            JOptionPane.showMessageDialog(this, "Advertisement not ready yet.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(advertisement.isEnabled()==true)
        {
            flag = JOptionPane.showConfirmDialog(this, "Are you sure want to disable this advertisement?", "Warning", JOptionPane.YES_NO_OPTION);
            if (flag == JOptionPane.YES_OPTION) {
                advertisement.setEnabled(false);
                System.out.println("Advertisement disabled");
            }
        }else if(advertisement.isEnabled()==false)
        {
            flag = JOptionPane.showConfirmDialog(this, "Are you sure want to enable this advertisement?", "Warning", JOptionPane.YES_NO_OPTION);
            if (flag == JOptionPane.YES_OPTION) {
                advertisement.setEnabled(true);
                System.out.println("Advertisement enabled");
            }
        }
        populateAdInventory();
    }//GEN-LAST:event_enableDisableAdJButtonActionPerformed

    private void removeAdJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAdJButtonActionPerformed
        // TODO add your handling code here:
        int flag;
        int selectedRow = adInventoryJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Advertisement.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Advertisement advertisement= (Advertisement) adInventoryJTable.getValueAt(selectedRow, 1);
        
        flag = JOptionPane.showConfirmDialog(this, "All the DSP's will be removed for this Advertisement. Are you sure want to remove this Advertisement?", "Warning", JOptionPane.YES_NO_OPTION);
        if (flag == JOptionPane.YES_OPTION) {
            //Remove DSP's first
            for(DSP dsp: adEnterprise.getDspDirectory().getDspList())
            {
                if(dsp.getAdvertisement()==advertisement)
                {
                    adEnterprise.getDspDirectory().removeDSP(dsp);
                }
            }
            System.out.println("DSP rules removed for Advertisement");
            //Delete the Ad
            adEnterprise.getAdInventory().removeAdvertisement(advertisement);
            System.out.println("Advertisement removed");
        }
        populateAdInventory();
    }//GEN-LAST:event_removeAdJButtonActionPerformed

    private void viewAdJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = adInventoryJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Advertisement.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Advertisement advertisement= (Advertisement) adInventoryJTable.getValueAt(selectedRow, 1);
        if(!advertisement.isReady())
        {
            JOptionPane.showMessageDialog(this, "Advertisement not ready yet.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ViewEditAdDetailsJPanel vadjp = new ViewEditAdDetailsJPanel(userProcessContainer,advertisement);
        userProcessContainer.add("ViewAdvertisementDetailsJPanel", vadjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adInventoryJTable;
    private javax.swing.JButton backJButton1;
    private javax.swing.JButton enableDisableAdJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeAdJButton;
    private javax.swing.JButton viewAdJButton;
    private javax.swing.JButton viewAdvertisementJJButton;
    // End of variables declaration//GEN-END:variables
}