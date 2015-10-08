/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier.SalesRepresentative;

import Business.Customer.Customer;
import Business.Enterprise.Enterprise;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.Organization;
import Business.Product.Product;
import Business.Supplier.Organizations.ShippingSpecialistOrganization;
import Business.Supplier.WorkRequests.OrderApprovalRequest;
import Business.Supplier.WorkRequests.ShippingRequest;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonam
 */
public class ManageCustomerOrdersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCustomerOrdersJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Organization organization;
    private UserAccount ua;

    public ManageCustomerOrdersJPanel(JPanel userProcessContainer, Enterprise enterprise, Organization organization, UserAccount ua) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.ua = ua;
        populateRequestTable();
        populateMyRequestTable();
    }

    private void populateRequestTable() {
        DefaultTableModel dtm = (DefaultTableModel) orgOrderRequestsJTable.getModel();
        dtm.setRowCount(0);

        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof OrderApprovalRequest) {
                Object row[] = new Object[7];

                row[0] = request;
                row[1] = ((OrderApprovalRequest) request).getOrder();
                row[2] = request.getSender();
                row[3] = request.getReceiver()==null ? null: request.getReceiver().getPerson().getName(); 
                row[4] = request.getStatus();
                row[5] = request.getRequestDate();
                row[6] = request.getResolveDate();
                dtm.addRow(row);
            }
        }

    }

    private void populateMyRequestTable() {
        DefaultTableModel dtm = (DefaultTableModel) myOrderRequestsJTable.getModel();
        dtm.setRowCount(0);

        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof OrderApprovalRequest) {
                if (request.getReceiver() == ua) {
                    Object row[] = new Object[7];
                    
                    row[0] = request;
                    row[1] = ((OrderApprovalRequest) request).getOrder();
                    row[2] = request.getSender();
                    row[3] = request.getReceiver().getPerson().getName(); 
                    row[4] = request.getStatus();
                    row[5] = request.getRequestDate();
                    row[6] = request.getResolveDate();
                    dtm.addRow(row);
                }
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
        refreshJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orgOrderRequestsJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        myOrderRequestsJTable = new javax.swing.JTable();
        rejectRequestJButton = new javax.swing.JButton();
        approveRequestJButton = new javax.swing.JButton();
        viewOrderDetaisJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        assignToMeJButton = new javax.swing.JButton();
        viewCustomerJButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Customer Orders");

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        orgOrderRequestsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Order ID", "Sender", "Receiver", "Status", "Request Date", "Resolve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orgOrderRequestsJTable);

        myOrderRequestsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Order ID", "Sender", "Receiver", "Status", "Request Date", "Resolve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(myOrderRequestsJTable);

        rejectRequestJButton.setText("Reject");
        rejectRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectRequestJButtonActionPerformed(evt);
            }
        });

        approveRequestJButton.setText("Approve");
        approveRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveRequestJButtonActionPerformed(evt);
            }
        });

        viewOrderDetaisJButton.setText("View Order");
        viewOrderDetaisJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderDetaisJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        assignToMeJButton.setText("Assign To Me");
        assignToMeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMeJButtonActionPerformed(evt);
            }
        });

        viewCustomerJButton3.setText("View Customer");
        viewCustomerJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustomerJButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Organization Customer Order Requests:");

        jLabel3.setText("My Customer Order Requests:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                        .addGap(373, 373, 373))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshJButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewCustomerJButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewOrderDetaisJButton)
                                .addGap(12, 12, 12)
                                .addComponent(assignToMeJButton))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(approveRequestJButton)
                                .addGap(18, 18, 18)
                                .addComponent(rejectRequestJButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(0, 125, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(viewOrderDetaisJButton)
                    .addComponent(assignToMeJButton)
                    .addComponent(viewCustomerJButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveRequestJButton)
                    .addComponent(rejectRequestJButton))
                .addContainerGap(179, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rejectRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectRequestJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = myOrderRequestsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        OrderApprovalRequest myWorkRequest = (OrderApprovalRequest) myOrderRequestsJTable.getValueAt(selectedRow, 0);
        if (myWorkRequest.isHasProcessed()) {
            JOptionPane.showMessageDialog(this, "Cannot alter request as already processed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int flag = 1;
        Order order = (Order) myOrderRequestsJTable.getValueAt(selectedRow, 1);
        flag = JOptionPane.showConfirmDialog(this, "Are you sure want to reject this order?", "Warning", JOptionPane.OK_CANCEL_OPTION);
        if (flag == JOptionPane.OK_OPTION) {
            for (OrderItem orderItem : order.getOrderItemList()) {
                Product p = orderItem.getProduct();
                p.setAvailibility(p.getAvailibility() + orderItem.getQuantity());
                p.setSoldCount(p.getSoldCount() - orderItem.getQuantity());
            }
            JOptionPane.showMessageDialog(this, "Order rejected. Order items added back to inventory.", "Update", JOptionPane.INFORMATION_MESSAGE);
        } else if (flag == JOptionPane.CANCEL_OPTION) {
            return;
        }
        myWorkRequest.setStatus("Rejected");
        myWorkRequest.getOrder().setStatus("Rejected");
        myWorkRequest.getOrder().setStatusBy(new Date());
        myWorkRequest.setResolveDate(new Date());
        myWorkRequest.setHasProcessed(true);
        System.out.println("Request status set rejected");
        populateRequestTable();
        populateMyRequestTable();
    }//GEN-LAST:event_rejectRequestJButtonActionPerformed

    private void approveRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveRequestJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = myOrderRequestsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        OrderApprovalRequest myWorkRequest = (OrderApprovalRequest) myOrderRequestsJTable.getValueAt(selectedRow, 0);
        if (myWorkRequest.isHasProcessed()) {
            JOptionPane.showMessageDialog(this, "Cannot alter request as already processed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        myWorkRequest.setStatus("Approved");
        System.out.println("Request status set approved");
        myWorkRequest.getOrder().setStatus("Sent For Shipping");
        myWorkRequest.getOrder().setStatusBy(new Date());
        myWorkRequest.setResolveDate(new Date());
        myWorkRequest.setHasProcessed(true);
        sendForShipping(myWorkRequest.getOrder());
        populateRequestTable();
        populateMyRequestTable();
    }//GEN-LAST:event_approveRequestJButtonActionPerformed

    private void sendForShipping(Order order) {
        ShippingRequest request = new ShippingRequest();
        request.setMessage("Approved for Shipping by " + ua.getPerson().getName());
        request.setSender(ua);
        request.setStatus("Sent");
        request.setOrder(order);
        request.setRequestDate(new Date());

        Organization org = null;
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof ShippingSpecialistOrganization) {
                org = o;
                break;
            }
        }

        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            ua.getWorkQueue().getWorkRequestList().add(request);
        }
        System.out.println("Shipping request created for this order");
    }
    private void viewOrderDetaisJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderDetaisJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orgOrderRequestsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Order order = (Order) orgOrderRequestsJTable.getValueAt(selectedRow, 1);

        ViewCustomerOrderDetailsJPanel vcodjp = new ViewCustomerOrderDetailsJPanel(userProcessContainer, order);
        userProcessContainer.add("ViewCustomerOrderDetailsJPanel", vcodjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewOrderDetaisJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.preferredLayoutSize(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void assignToMeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orgOrderRequestsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Work Request.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        WorkRequest myWorkRequest = (WorkRequest) orgOrderRequestsJTable.getValueAt(selectedRow, 0);
        if(myWorkRequest.getReceiver()!=null)
        {
            JOptionPane.showMessageDialog(this, "Request is already assigned to "+myWorkRequest.getReceiver().getPerson().getName(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        myWorkRequest.setStatus("Under Review");
        myWorkRequest.setReceiver(ua);
        System.out.println("Order assigned to "+ua.getUsername());
        populateRequestTable();
        populateMyRequestTable();
    }//GEN-LAST:event_assignToMeJButtonActionPerformed

    private void viewCustomerJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustomerJButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = orgOrderRequestsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Customer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserAccount userAccount = (UserAccount) orgOrderRequestsJTable.getValueAt(selectedRow, 2);
        Customer customer = (Customer) userAccount.getPerson();
        ViewCustomerJPanel vcjp = new ViewCustomerJPanel(userProcessContainer, customer);
        userProcessContainer.add("ViewCustomerJPanel", vcjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewCustomerJButton3ActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
        populateMyRequestTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveRequestJButton;
    private javax.swing.JButton assignToMeJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable myOrderRequestsJTable;
    private javax.swing.JTable orgOrderRequestsJTable;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton rejectRequestJButton;
    private javax.swing.JButton viewCustomerJButton3;
    private javax.swing.JButton viewOrderDetaisJButton;
    // End of variables declaration//GEN-END:variables
}
