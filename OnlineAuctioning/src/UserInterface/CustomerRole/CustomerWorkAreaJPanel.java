/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import Business.Advertiser.Advertisement.Advertisement;
import Business.Advertiser.Advertisement.SSPDSPHolder;
import Business.Advertiser.DemandSidePlatform.DSP;
import Business.Auction.Auction;
import Business.Business.EcoSystem;
import Business.Customer.Activity.CustomerActivity;
import Business.Customer.Customer;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PublisherEnterprise;
import Business.Organization.OrganizationDirectory;
import Business.Publisher.AdSpace.AdSpace;
import Business.Publisher.ServerSidePlatform.SSP;
import Business.Supplier.MasterOrderCatalog;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Guest
 */
public class CustomerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private Enterprise enterprise;
    private OrganizationDirectory organizationDirectory;
    private MasterOrderCatalog masterOrderCatalog;
    private UserAccount ua;
    private Customer customer;
    PublisherEnterprise publisherEnterprise;

    public CustomerWorkAreaJPanel(JPanel userProcessContainer, EcoSystem ecoSystem, Enterprise enterprise, UserAccount ua, PublisherEnterprise publisherEnterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        this.ua = ua;
        this.enterprise = enterprise;
        this.organizationDirectory = enterprise.getOrganizationDirectory();
        this.masterOrderCatalog = ecoSystem.getMasterOrderCatalog();
        this.customer = (Customer) ua.getPerson();
        this.publisherEnterprise = publisherEnterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseProductCatalogJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        viewCustomerOrdersJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        browseProductCatalogJButton.setText("Browse Product Catalog>>");
        browseProductCatalogJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseProductCatalogJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Work Area");

        viewCustomerOrdersJButton.setText("View Customer Orders>>");
        viewCustomerOrdersJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustomerOrdersJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(backJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewCustomerOrdersJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(browseProductCatalogJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(browseProductCatalogJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewCustomerOrdersJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backJButton)
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseProductCatalogJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseProductCatalogJButtonActionPerformed
        // TODO add your handling code here:

        ArrayList<SSPDSPHolder> sspdspHolderList = new ArrayList<>();

        if (publisherEnterprise != null) {
            ArrayList<Advertisement> ignoreList = new ArrayList<>();

            StringBuilder browsingHistory = new StringBuilder();
            for (CustomerActivity activity : customer.getActivityList().getCustomerActivityList()) {
                browsingHistory.append(activity.getKeywords().toLowerCase());
                browsingHistory.append(",");
            }

            int i = 0;
            for (AdSpace adSpace : publisherEnterprise.getAdSpaceInventory().getAdSpaceList()) {
                System.out.println("Checking for Ad Space");
                if (adSpace.isEnabled()) {
                    System.out.println("SSP selecttion started");
                    SSP ssp = publisherEnterprise.getSSPDirectory().getSSPForAuction(customer, adSpace);
                    if (ssp == null) {
                        System.out.println("No SSP found, auction cancelled");
                        break;
                    }
                    Auction auction = ecoSystem.getAuctionDirectory().createAndAddAuction();
                    auction.setNetwork(publisherEnterprise.getNetwork());
                    System.out.println("New auction created and added to auction directory");
                    System.out.println("Auction started for " + adSpace.getTitle());
                    DSP dsp = auction.getCalualteAuctionResult(ssp, customer, publisherEnterprise.getNetwork(), ignoreList, browsingHistory);
                    System.out.println("Auction Completed for Ad Space " + adSpace.getTitle());
                    if (ssp != null && dsp != null) {
                        i++;
                        SSPDSPHolder sspdspHolder = new SSPDSPHolder();
                        sspdspHolder.setButtonName("button" + String.valueOf(i));
                        sspdspHolder.setDsp(dsp);
                        sspdspHolder.setSsp(ssp);
                        sspdspHolderList.add(sspdspHolder);
                        System.out.println("DSP added to ignore list");
                        ignoreList.add(dsp.getAdvertisement());
                        //Storing winner for the auction
                        auction.setInitiatingSSP(ssp);
                        auction.setWinningDSP(dsp);
                    }
                }
            }

            if (!sspdspHolderList.isEmpty()) {
                System.out.println("Auction results stored");
            }
        }
        else
        {
            System.out.println("No publisher selected, No auction created");
        }

        BrowseProductsJPanel bpjp = new BrowseProductsJPanel(userProcessContainer, organizationDirectory, ecoSystem, ua, publisherEnterprise, sspdspHolderList);
        userProcessContainer.add("BrowseProductsJPanel", bpjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_browseProductCatalogJButtonActionPerformed

    private void viewCustomerOrdersJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustomerOrdersJButtonActionPerformed
        // TODO add your handling code here:
        ViewCustomerOrdersJPanel vcojp = new ViewCustomerOrdersJPanel(userProcessContainer, masterOrderCatalog, customer);
        userProcessContainer.add("ViewCustomerOrdersJPanel", vcojp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewCustomerOrdersJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton browseProductCatalogJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton viewCustomerOrdersJButton;
    // End of variables declaration//GEN-END:variables
}
