/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminRole;

import UserInterface.CustomerAdminRole.*;
import Business.Business.EcoSystem;
import Business.Customer.Activity.CustomerActivity;
import Business.Customer.Activity.CustomerActivity.ActivityType;
import Business.Customer.Customer;
import Business.Enterprise.AdvertiserEnterprise;
import Business.Enterprise.CustomerEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonam
 */
public class ViewAllCustomerBrowsingHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewCustomerBrowsingHistoryJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    public ViewAllCustomerBrowsingHistoryJPanel(JPanel userProcessContainer, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem=ecoSystem;
        populateNetworks();
    }

    private void populateNetworks()
    {
        networkJComboBox.removeAllItems();
        for(Network network:ecoSystem.getNetworkList())
        {
            networkJComboBox.addItem(network);
        }
    }
    
    private void populateEnterpriseCombobox(Network network) {
        enterpriseJComboBox.removeAllItems();

        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) 
        {
            if(enterprise instanceof CustomerEnterprise)
            {
                enterpriseJComboBox.addItem(enterprise);
            }
        }
    }
    
    private void populateOrganizations(CustomerEnterprise enterprise) {
        organizationJComboBox.removeAllItems();
        //Populate Customer Organization
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o.getName().equals(Organization.Type.Customer.getValue())) {
                organizationJComboBox.addItem(o);
            }
        }
    }

    private void populateCustomers(Organization org) {
        customerJComboBox.removeAllItems();
        for (Person p : org.getPersonDirectory().getPersonDirectory()) {
            customerJComboBox.addItem((Customer) p);
        }
    }

    private void populateCustomerHistory(Customer c) {
        DefaultTableModel dtm = (DefaultTableModel) customerJTable.getModel();
        dtm.setRowCount(0);
        if (c != null) {
            for (CustomerActivity activity : c.getActivityList().getCustomerActivityList()) {
                Object row[] = new Object[3];
                row[0] = activity;
                row[1] = activity.getActivityTime();
                row[2] = activity.getKeywords();
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

        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerJTable = new javax.swing.JTable();
        viewCustomerJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        customerJComboBox = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        importActivitiesJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        enterpriseJComboBox = new javax.swing.JComboBox();

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        customerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activity Type", "Time", "Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(customerJTable);

        viewCustomerJButton.setText("View Customer");
        viewCustomerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustomerJButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Organization:");

        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer:");

        customerJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerJComboBoxActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("View Customer Browsing History");

        importActivitiesJButton.setText("Import Activities");
        importActivitiesJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importActivitiesJButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Network:");

        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Enterprise");

        enterpriseJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseJComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(networkJComboBox, 0, 200, Short.MAX_VALUE)
                                .addComponent(organizationJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customerJComboBox, 0, 200, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewCustomerJButton)
                        .addGap(18, 18, 18)
                        .addComponent(importActivitiesJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(customerJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(viewCustomerJButton)
                    .addComponent(importActivitiesJButton))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewCustomerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustomerJButtonActionPerformed
        // TODO add your handling code here:
        Customer c = (Customer) customerJComboBox.getSelectedItem();
        if (c == null) {
            JOptionPane.showMessageDialog(this, "Please select a Customer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ViewCustomerDetailsJPanel vcdjp = new ViewCustomerDetailsJPanel(userProcessContainer, c);
        userProcessContainer.add("ViewCustomerDetailsJPanel", vcdjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewCustomerJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        // TODO add your handling code here:
        Organization org = (Organization) organizationJComboBox.getSelectedItem();
        if (org != null) {
            populateCustomers(org);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void customerJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerJComboBoxActionPerformed
        // TODO add your handling code here:
        Customer c = (Customer) customerJComboBox.getSelectedItem();
        if (c != null) {
            populateCustomerHistory(c);
        }
    }//GEN-LAST:event_customerJComboBoxActionPerformed

    private void importActivitiesJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importActivitiesJButtonActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser chooser = new JFileChooser(userDir +"/Desktop");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new CSVFilter());
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String fileName = f.getAbsolutePath();
            importCSV(fileName);
        }
    }//GEN-LAST:event_importActivitiesJButtonActionPerformed

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed
        // TODO add your handling code here:
        Network network = (Network) networkJComboBox.getSelectedItem();
        if (network != null)
        {
            populateEnterpriseCombobox(network);
        }
    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void enterpriseJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseJComboBoxActionPerformed
        // TODO add your handling code here:
        CustomerEnterprise customerEnterprise=(CustomerEnterprise) enterpriseJComboBox.getSelectedItem();
        if(customerEnterprise!=null)
        {
            populateOrganizations(customerEnterprise);
        }
    }//GEN-LAST:event_enterpriseJComboBoxActionPerformed

    private void importCSV(String filename) {
        String fileToParse = filename;
        BufferedReader fileReader = null;

        //Delimiter used in CSV file
        final String DELIMITER = ",";
        try {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));

            //Read the file line by line
            System.out.println("Activity Import Started");
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                System.out.println("Reading new line");
                String[] tokens = line.split(DELIMITER);
                if (tokens.length != 4) {
                    System.out.println("Invalid line, ignoring");
                    continue;
                }
                if(tokens[0].length()==0 
                    || tokens[1].length()==0 
                    || tokens[2].length()==0 
                    || tokens[3].length()==0)
                {
                    System.out.println("Invalid inputs in line, ignoring");
                    continue;
                }
                UserAccount userAccount= getCustomerAccount(tokens[0]);
                if(userAccount==null)
                {
                    System.out.println("Customer not found.");
                    continue;
                }
                Customer customer= (Customer)userAccount.getPerson();
                
                
                ActivityType type=null;
                if(tokens[1].equals(ActivityType.AddToCart.name()))
                {
                    type=ActivityType.AddToCart;
                }else if(tokens[1].equals(ActivityType.BuyProduct.name()))
                {
                    type=ActivityType.BuyProduct;
                }else if(tokens[1].equals(ActivityType.ViewProduct.name()))
                {
                    type=ActivityType.ViewProduct;
                }else if(tokens[1].equals(ActivityType.SearchProduct.name()))
                {
                    type=ActivityType.SearchProduct;
                }else if(tokens[1].equals(ActivityType.AdClick.name()))
                {
                    type=ActivityType.AdClick;
                }
                
                if(type==null)
                {
                    System.out.println("Invalid inputs in line, ignoring");
                    continue;
                }
                
                String keyWord=tokens[2].trim();
                if(keyWord.length()==0)
                {
                    System.out.println("Invalid inputs in line, ignoring");
                    continue;
                }
                
                
                SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
                Date timeStamp=null;
                try{
                timeStamp= ft.parse(tokens[3]);
                }
                catch(Exception ex)
                {
                    System.out.println("Invalid inputs in line, ignoring");
                    continue;
                }
                CustomerActivity activity=null;
                try
                {
                System.out.println("Checking duplicate activity.");
                boolean flag=customer.getActivityList().searchDuplicateActivity(type, keyWord, ft.format(timeStamp));
                if(flag)
                {
                    System.out.println("Duplicate activity found, ignoring");
                    continue;
                }
                System.out.println("Creating activity.");
                activity= customer.getActivityList().logCustomerActivity();
                activity.setActivityType(type);
                activity.setKeywords(keyWord);
                activity.setActivityTime(timeStamp);
                }
                catch(Exception ex)
                {
                    System.out.println("Problem creating activity, ignoring");
                    if(activity!=null)
                    {
                        customer.getActivityList().removeActivity(activity);
                    }
                    continue;
                }
                System.out.println("Activity created.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            populateNetworks();
            System.out.println("Activity Import complete.");
            JOptionPane.showMessageDialog(this, "Activity Import complete.", "Update", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private UserAccount getCustomerAccount(String userName) {
        UserAccount userAccount = null;
        if (userAccount == null) {
            //Step 2: Go inside each network and check each Enterprise
            for (Network network : ecoSystem.getNetworkList()) {
                //Step 2.1: Check each Enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enterprise instanceof CustomerEnterprise) {
                        //Check again each organization
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().getUser(userName);
                            if (userAccount != null) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return userAccount;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox customerJComboBox;
    private javax.swing.JTable customerJTable;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JButton importActivitiesJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JButton viewCustomerJButton;
    // End of variables declaration//GEN-END:variables
}

class CSVFilter extends javax.swing.filechooser.FileFilter {

    public boolean accept(File f) {

        return f.isFile() && f.getName().toLowerCase().endsWith(".csv");
    }

    public String getDescription() {
        return "*.csv";
    }
}
