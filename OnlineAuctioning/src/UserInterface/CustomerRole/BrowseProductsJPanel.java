/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import Business.Advertiser.Advertisement.SSPDSPHolder;
import Business.Advertiser.DemandSidePlatform.DSP;
import Business.Business.EcoSystem;
import Business.Customer.Activity.CustomerActivity;
import Business.Customer.Customer;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PublisherEnterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Product.Product;
import Business.Publisher.Organizations.PublisherAccountManagerOrganization;
import Business.Publisher.ServerSidePlatform.SSP;
import Business.Publisher.WorkRequests.PostPaymentWorkRequest;
import Business.Supplier.MasterOrderCatalog;
import Business.Supplier.Organizations.SalesRepresentativeOrganization;
import Business.Supplier.WorkRequests.OrderApprovalRequest;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guest
 */
public class BrowseProductsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BrowseProducts
     */
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private OrganizationDirectory organizationDirectory;
    private MasterOrderCatalog masterOrderCatalog;
    private Customer customer;
    private UserAccount userAccount;
    private Order order;
    private boolean isCheckedOut = false;
    private PublisherEnterprise publisherEnterprise;
    private ArrayList<SSPDSPHolder> sspdspHolderList;

    public BrowseProductsJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, EcoSystem ecoSystem, UserAccount userAccount, PublisherEnterprise publisherEnterprise, ArrayList<SSPDSPHolder> sspdspHolderList) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        this.organizationDirectory = organizationDirectory;
        this.masterOrderCatalog = ecoSystem.getMasterOrderCatalog();
        this.userAccount = userAccount;
        this.customer = (Customer) userAccount.getPerson();
        this.order = this.customer.getOrder();
        this.sspdspHolderList=sspdspHolderList;
        this.publisherEnterprise=publisherEnterprise;

        populateSuppliers();
        refreshProductTable();
        refreshOrderTable();

        quantityJSpinner.setValue(1);
        
        for (SSPDSPHolder sspdspHolder : sspdspHolderList) {
            try {
                SSP ssp = sspdspHolder.getSsp();
                DSP dsp = sspdspHolder.getDsp();
                System.out.println("Populating advertisement in Ad Space "+ssp.getAdSpace().getTitle());
                Image image = ImageIO.read(new File(sspdspHolder.getDsp().getAdvertisement().getLocation()));
                image = image.getScaledInstance(dsp.getAdvertisement().getWidth(), dsp.getAdvertisement().getHeight(), Image.SCALE_SMOOTH);
                JButton button = new JButton();
                button.setIcon(new ImageIcon(image));
                button.setName(sspdspHolder.getButtonName());
                button.setContentAreaFilled(false);
                button.setBounds(ssp.getAdSpace().getX(), ssp.getAdSpace().getY(), dsp.getAdvertisement().getWidth(), dsp.getAdvertisement().getHeight());
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        customerClicked(e);
                    }
                });
                this.add(button);
                validate();
                repaint();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Cannot show this image", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(!sspdspHolderList.isEmpty())
        {
            System.out.println("Ads Displayed");
        }
        else
        {
            System.out.println("No Ads Displayed");
        }
    }

    private void customerClicked(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        b.setEnabled(false);
        DSP dsp = null;
        SSP ssp = null;

        for (SSPDSPHolder sspdspHolder : sspdspHolderList) {
            if (b.getName().equals(sspdspHolder.getButtonName())) {
                dsp = sspdspHolder.getDsp();
                ssp = sspdspHolder.getSsp();
                break;
            }
        }
        //Increament click count
        dsp.getAdvertisement().setClickCount(dsp.getAdvertisement().getClickCount() + 1);
        System.out.println("Customer clicked on "+ dsp.getAdvertisement().getTitle());
        Organization organization = null;
        for (Organization org : publisherEnterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof PublisherAccountManagerOrganization) {
                organization = org;
                break;
            }
        }
        
        CustomerActivity activity=customer.getActivityList().logCustomerActivity();
        activity.setActivityTime(new Date());
        activity.setActivityType(CustomerActivity.ActivityType.AdClick);
        activity.setKeywords(dsp.getAdvertisement().getAdWords());
        System.out.println("Customer activity logged");

        PostPaymentWorkRequest myWorkRequest = new PostPaymentWorkRequest();
        myWorkRequest.setMessage(userAccount.getPerson().getName() + " clicked to ad");
        myWorkRequest.setSender(userAccount);
        myWorkRequest.setRequestDate(new Date());
        myWorkRequest.setStatus("Sent");
        myWorkRequest.setDsp(dsp);
        myWorkRequest.setSsp(ssp);
        myWorkRequest.setCustomer((Customer) userAccount.getPerson());

        if (organization != null) {
            organization.getWorkQueue().getWorkRequestList().add(myWorkRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(myWorkRequest);
        }
        System.out.println("Post Payment request sent to Account Manager");
    }

    private void populateSuppliers() {
        supplierComboBox.removeAllItems();
        for (Network network : ecoSystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof SupplierEnterprise) {
                    supplierComboBox.addItem(enterprise);
                }
            }

        }
    }

    private void refreshProductTable(String keyWord) {
        DefaultTableModel dtm = (DefaultTableModel) productJTable.getModel();
        dtm.setRowCount(0);

        SupplierEnterprise s = (SupplierEnterprise) supplierComboBox.getSelectedItem();
        for (Product p : s.getProductCatalog().getProductCatalog()) {
            if (keyWord.toLowerCase().equals(p.getProdName().toLowerCase())) {
                Object row[] = new Object[4];
                row[0] = p;
                row[1] = p.getModelNumber();
                row[2] = p.getPrice();
                row[3] = p.getAvailibility();
                dtm.addRow(row);
            }
        }

    }

    private void refreshProductTable() {
        DefaultTableModel dtm = (DefaultTableModel) productJTable.getModel();
        dtm.setRowCount(0);
        SupplierEnterprise s = (SupplierEnterprise) supplierComboBox.getSelectedItem();

        if (s != null) {
            for (Product p : s.getProductCatalog().getProductCatalog()) {
                Object row[] = new Object[4];
                row[0] = p;
                row[1] = p.getModelNumber();
                row[2] = p.getPrice();
                row[3] = p.getAvailibility();
                dtm.addRow(row);
            }
        }
    }

    private void refreshOrderTable() {
        DefaultTableModel dtm = (DefaultTableModel) orderJTable.getModel();
        dtm.setRowCount(0);

        for (OrderItem oi : order.getOrderItemList()) {
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getProduct().getPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getSalesPrice();

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

        supplierComboBox = new javax.swing.JComboBox();
        txtSearchKeyWord = new javax.swing.JTextField();
        searchProductJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productJTable = new javax.swing.JTable();
        viewProductDetailJButton = new javax.swing.JButton();
        addToCartJButton = new javax.swing.JButton();
        quantityJSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        viewItemJButton = new javax.swing.JButton();
        modifyQuantityJButton = new javax.swing.JButton();
        checkoutJButton = new javax.swing.JButton();
        removeItemJButton = new javax.swing.JButton();
        refreshCartJButton = new javax.swing.JButton();
        txtNewQuantity = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        supplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboBoxActionPerformed(evt);
            }
        });

        searchProductJButton.setText("Search Product");
        searchProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductJButtonActionPerformed(evt);
            }
        });

        productJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Product Id", "Price", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productJTable);

        viewProductDetailJButton.setText("View Product Detail");
        viewProductDetailJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductDetailJButtonActionPerformed(evt);
            }
        });

        addToCartJButton.setText("Add To Cart");
        addToCartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartJButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantity");

        jLabel3.setText("Supplier Product Catalog");

        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Price", "Quantity", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderJTable);

        jLabel4.setText("Items In Cart");

        viewItemJButton.setText("View Item");
        viewItemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewItemJButtonActionPerformed(evt);
            }
        });

        modifyQuantityJButton.setText("Modify");
        modifyQuantityJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyQuantityJButtonActionPerformed(evt);
            }
        });

        checkoutJButton.setText("Checkout");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });

        removeItemJButton.setText("Remove");
        removeItemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemJButtonActionPerformed(evt);
            }
        });

        refreshCartJButton.setText("Refresh");
        refreshCartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCartJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Browse Products");

        jLabel6.setText("Supplier:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSearchKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchProductJButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(viewProductDetailJButton)
                                    .addGap(149, 149, 149)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                    .addComponent(addToCartJButton))
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewItemJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(modifyQuantityJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkoutJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeItemJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refreshCartJButton)))
                        .addContainerGap(121, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backJButton)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSearchKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchProductJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewProductDetailJButton)
                    .addComponent(addToCartJButton)
                    .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewItemJButton)
                    .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyQuantityJButton)
                    .addComponent(checkoutJButton)
                    .addComponent(removeItemJButton)
                    .addComponent(refreshCartJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backJButton)
                .addContainerGap(318, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewProductDetailJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductDetailJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Product p = (Product) productJTable.getValueAt(selectedRow, 0);
        
        CustomerActivity activity=customer.getActivityList().logCustomerActivity();
        activity.setActivityTime(new Date());
        activity.setActivityType(CustomerActivity.ActivityType.ViewProduct);
        activity.setKeywords(p.getProdName());
        System.out.println("Customer activity logged");
        
        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(userProcessContainer, p);
        userProcessContainer.add("ViewProductDetailJPanel", vpdjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewProductDetailJButtonActionPerformed

    private void viewItemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewItemJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an item from cart", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        OrderItem oi = (OrderItem) orderJTable.getValueAt(selectedRow, 0);
        ViewOrderItemDetailJPanel voijp = new ViewOrderItemDetailJPanel(userProcessContainer, oi);
        userProcessContainer.add("ViewOrderItemDetailJPanel", voijp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewItemJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        int flag = 1;
        if (order.getOrderItemList().isEmpty()) {
            isCheckedOut = true;
        }
        if (!isCheckedOut) {
            flag = JOptionPane.showConfirmDialog(this, "The order is not checked out. Going back will delete the cart. Do you want to continue", "Warning", JOptionPane.OK_CANCEL_OPTION);
        }
        if (flag == JOptionPane.OK_OPTION) {
            for (OrderItem orderItem : order.getOrderItemList()) {
                Product p = orderItem.getProduct();
                p.setAvailibility(p.getAvailibility() + orderItem.getQuantity());
            }
            //clearing cart
            order.getOrderItemList().clear();
            JOptionPane.showMessageDialog(this, "Cart deleted. Do visit us again.", "Update", JOptionPane.INFORMATION_MESSAGE);
        } else if (flag == JOptionPane.CANCEL_OPTION) {
            return;
        }
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void searchProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductJButtonActionPerformed
        // TODO add your handling code here:
        String keyWord = txtSearchKeyWord.getText();
        if (keyWord.length() == 0 || keyWord.startsWith(" ")) {
            JOptionPane.showMessageDialog(this, "Please enter valid string..", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CustomerActivity activity=customer.getActivityList().logCustomerActivity();
        activity.setActivityTime(new Date());
        activity.setActivityType(CustomerActivity.ActivityType.SearchProduct);
        activity.setKeywords(keyWord);
        System.out.println("Customer searching activity logged");
        refreshProductTable(keyWord);
    }//GEN-LAST:event_searchProductJButtonActionPerformed

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed
        // TODO add your handling code here:
        int flag = 1;
        if (order.getOrderItemList().isEmpty()) {
            isCheckedOut = true;
        }
        if (!isCheckedOut) {
            flag = JOptionPane.showConfirmDialog(this, "The order is not checked out. Changing supplier will delete the cart. Do you want to continue", "Warning", JOptionPane.OK_CANCEL_OPTION);
        }
        if (flag == JOptionPane.OK_OPTION) {
            for (OrderItem orderItem : order.getOrderItemList()) {
                Product p = orderItem.getProduct();
                p.setAvailibility(p.getAvailibility() + orderItem.getQuantity());
            }
            //clearing cart
            order.getOrderItemList().clear();
        } else if (flag == JOptionPane.CANCEL_OPTION) {
            return;
        }
        refreshProductTable();
        refreshOrderTable();
    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void addToCartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartJButtonActionPerformed
        // TODO add your handling code here:
        isCheckedOut = false;
        int quantity = (Integer) quantityJSpinner.getValue();

        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Product product = (Product) productJTable.getValueAt(selectedRow, 0);
        
        CustomerActivity activity=customer.getActivityList().logCustomerActivity();
        activity.setActivityTime(new Date());
        activity.setActivityType(CustomerActivity.ActivityType.AddToCart);
        activity.setKeywords(product.getProdName());
        System.out.println("Customer activity logged");
        
        if (quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter correct quantitiy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (quantity <= 0 || quantity > product.getAvailibility()) {
            JOptionPane.showMessageDialog(this, "Insufficient item in stock", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean flag = true;
        ArrayList<OrderItem> olist = order.getOrderItemList();

        for (OrderItem orderItem : olist) {
            System.out.println("Checking if product already exists");
            if (orderItem.getProduct() == product) {
                int oldQuantity = orderItem.getQuantity();
                int newQuantity = quantity + oldQuantity;
                orderItem.setQuantity(newQuantity);
                product.setAvailibility(product.getAvailibility() - quantity);
                flag = false;
                System.out.println("Product found, information updated");
            }
        }
        if (flag) {
            OrderItem oi = order.addOrderItem(product, quantity);
            product.setAvailibility(product.getAvailibility() - quantity);
            System.out.println("Added new item to the cart");
        }
        String caption = "You have added the product:" + product + " with quantity:" + quantity;
        JOptionPane.showMessageDialog(this, caption, "Update", JOptionPane.INFORMATION_MESSAGE);
        refreshOrderTable();
        refreshProductTable();

    }//GEN-LAST:event_addToCartJButtonActionPerformed

    private void modifyQuantityJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyQuantityJButtonActionPerformed
        // TODO add your handling code here:
        String modifiedQuantityString = txtNewQuantity.getText();

        try {
            int modifiedQuantity = Integer.parseInt(modifiedQuantityString);
            if (modifiedQuantity < 0) {
                JOptionPane.showMessageDialog(this, "Quanity cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int selectedRow = orderJTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Please select an item from cart", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            OrderItem oi = (OrderItem) orderJTable.getValueAt(selectedRow, 0);

            if (modifiedQuantity > oi.getQuantity()) {
                int value = modifiedQuantity - oi.getQuantity();
                if (oi.getProduct().getAvailibility() < value) {
                    JOptionPane.showMessageDialog(this, "Insufficient item in stock", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                oi.setQuantity(modifiedQuantity);
                int avail = oi.getProduct().getAvailibility();
                int newAvail = avail - value;
                oi.getProduct().setAvailibility(newAvail);
            } else if (modifiedQuantity == 0) {
                int flag = JOptionPane.showConfirmDialog(this, "Are you sure want to remove this item?", "Warning", JOptionPane.YES_NO_OPTION);
                if (flag == 0) {
                    order.removeOrderItem(oi);
                    refreshOrderTable();
                    refreshProductTable();
                }
            } else {
                int value = oi.getQuantity() - modifiedQuantity;
                oi.setQuantity(modifiedQuantity);
                int avail = oi.getProduct().getAvailibility();
                int newAvail = avail + value;
                oi.getProduct().setAvailibility(newAvail);
            }
            System.out.println("Order item modified");
            refreshOrderTable();
            refreshProductTable();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter correct value", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


    }//GEN-LAST:event_modifyQuantityJButtonActionPerformed

    private void removeItemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an item from cart", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int flag = JOptionPane.showConfirmDialog(this, "Are you sure want to remove this item?", "Warning", JOptionPane.YES_NO_OPTION);
        if (flag == 0) {
            OrderItem oi = (OrderItem) orderJTable.getValueAt(selectedRow, 0);
            order.removeOrderItem(oi);
            System.out.println("Order item removed");
            refreshOrderTable();
            refreshProductTable();
        }
        if (order.getOrderItemList().isEmpty()) {
            isCheckedOut = true;
        }
    }//GEN-LAST:event_removeItemJButtonActionPerformed

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:
        //add order to master order catalog
        if (order.getOrderItemList().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add items to the cart before check out.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int orderTotal = 0;
        order.setOrderDate(new Date());
        masterOrderCatalog.addOrder(order);
        System.out.println("Order added to Master Order Catalog");
        for (OrderItem orderItem : order.getOrderItemList()) {
            Product p = orderItem.getProduct();
            orderTotal = orderTotal + p.getPrice() * orderItem.getQuantity();
            p.setSoldCount(p.getSoldCount() + orderItem.getQuantity());
            
            CustomerActivity activity=customer.getActivityList().logCustomerActivity();
            activity.setActivityTime(new Date());
            activity.setActivityType(CustomerActivity.ActivityType.BuyProduct);
            activity.setKeywords(p.getProdName());
            System.out.println("Customer activity logged");
        }
        order.setOrderTotal(orderTotal);
        /*Push the order to Sales representative work queue*/
        proceedForOrderApproval();
        isCheckedOut = true;
        JOptionPane.showMessageDialog(this, "Order has been placed. Thank you for shopping with us.", "Update", JOptionPane.INFORMATION_MESSAGE);
        //delete order and create new order
        //assign to current order
        order = customer.createNewOrder();
        System.out.println("Temporary cart created");
        refreshOrderTable();
    }//GEN-LAST:event_checkoutJButtonActionPerformed

    private void proceedForOrderApproval() {
        order.setStatus("Pending");
        order.setStatusBy(new Date());
        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setMessage("Order for " + customer.getName());
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setOrder(order);
        request.setRequestDate(new Date());

        SupplierEnterprise s = (SupplierEnterprise) supplierComboBox.getSelectedItem();

        Organization org = null;
        for (Organization o : s.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof SalesRepresentativeOrganization) {
                org = o;
                break;
            }
        }

        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        System.out.println("Order approval request sent to Sales Representative organization");
    }
    private void refreshCartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshCartJButtonActionPerformed
        // TODO add your handling code here:
        refreshOrderTable();
        refreshProductTable();
    }//GEN-LAST:event_refreshCartJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton checkoutJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modifyQuantityJButton;
    private javax.swing.JTable orderJTable;
    private javax.swing.JTable productJTable;
    private javax.swing.JSpinner quantityJSpinner;
    private javax.swing.JButton refreshCartJButton;
    private javax.swing.JButton removeItemJButton;
    private javax.swing.JButton searchProductJButton;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JTextField txtNewQuantity;
    private javax.swing.JTextField txtSearchKeyWord;
    private javax.swing.JButton viewItemJButton;
    private javax.swing.JButton viewProductDetailJButton;
    // End of variables declaration//GEN-END:variables
}
