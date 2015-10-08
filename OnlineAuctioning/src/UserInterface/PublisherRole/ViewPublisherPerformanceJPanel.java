/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PublisherRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.PublisherEnterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Publisher.AdSpace.AdSpace;
import Business.Publisher.Organizations.PublisherAccountManagerOrganization;
import Business.Publisher.WorkRequests.RequestPaymentWorkRequest;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import UserInterface.Publisher.AdSpaceManagerRole.ViewAdSpaceJPanel;
import UserInterface.Publisher.AdSpaceManagerRole.ViewEditAdSpaceDetailsJPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Sonam
 */
public class ViewPublisherPerformanceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAdvertiserPerformanceJPanel
     */
    private OrganizationDirectory organizationDirectory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private PublisherEnterprise publisherEnterprise;
    DefaultCategoryDataset adSpaceRevenueDataset=new DefaultCategoryDataset();
    public ViewPublisherPerformanceJPanel(JPanel userProcessContainer,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise=enterprise;
        this.publisherEnterprise=(PublisherEnterprise)enterprise;
        this.organizationDirectory = enterprise.getOrganizationDirectory();
        populatePerformanceTable();
    }
    
    private void populatePerformanceTable()
    {
        DefaultTableModel dtm= (DefaultTableModel) publisherPerformanceJTable.getModel();
        dtm.setRowCount(0);
        for(AdSpace adSpace: publisherEnterprise.getAdSpaceInventory().getAdSpaceList())
        {
            if(adSpace.isReady())
            {
                Object row[]=new Object[2];
                row[0]=adSpace;
                double revenue=getRevenueGenerated(adSpace);
                row[1]=revenue;
                dtm.addRow(row);

                adSpaceRevenueDataset.addValue(revenue, "Revenue", adSpace.getTitle());
            }
        }
        createCharts();
    }
    
    private double getRevenueGenerated(AdSpace adSpace)
    {
        Organization organization=null;
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof PublisherAccountManagerOrganization)
            {
                organization=org;
                break;
            }
        }
        
        double revenue=0;
        for(UserAccount ua:organization.getUserAccountDirectory().getUserAccountList())
        {
            for(WorkRequest wr: ua.getWorkQueue().getWorkRequestList())
            {
                if(wr instanceof RequestPaymentWorkRequest)
                {
                    RequestPaymentWorkRequest myWorkRequest= (RequestPaymentWorkRequest)wr;
                    if(myWorkRequest.getAdSpace()==adSpace && myWorkRequest.isPaid())
                    {
                        revenue=revenue+myWorkRequest.getAmount();
                    }

                }
            }
            
        }
        
        return revenue;
    }
    
        private void createCharts()
    {
        /*Click Count*/
        JFreeChart adSpaceRevenueChart= ChartFactory.createBarChart3D("Performance By Revenue", "Ad Space", "Revenue", adSpaceRevenueDataset, PlotOrientation.VERTICAL, true, false, false);
        adSpaceRevenueChart.setBackgroundPaint(Color.white);
        CategoryPlot adSpaceRevenueChartPlot = adSpaceRevenueChart.getCategoryPlot();
        adSpaceRevenueChartPlot.setBackgroundPaint(Color.lightGray);    
        
        CategoryAxis adSpaceRevenueDomainAxis = adSpaceRevenueChartPlot.getDomainAxis();
        adSpaceRevenueDomainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        NumberAxis adSpaceRevenueRangeAxis = (NumberAxis) adSpaceRevenueChartPlot.getRangeAxis();
        adSpaceRevenueRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        ChartPanel adSpaceRevenueChartPanel= new ChartPanel(adSpaceRevenueChart);
        adSpaceRevenueJPanel.setPreferredSize(new Dimension(300,400));
        adSpaceRevenueJPanel.add(adSpaceRevenueChartPanel);
        adSpaceRevenueJPanel.validate();
        adSpaceRevenueJPanel.setVisible(true);
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
        publisherPerformanceJTable = new javax.swing.JTable();
        adSpaceRevenueJPanel = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();
        viewAdSpaceDetailsJButton = new javax.swing.JButton();
        viewAdSpaceJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Publisher Performance");

        publisherPerformanceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ad Space", "Revenue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(publisherPerformanceJTable);

        adSpaceRevenueJPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        adSpaceRevenueJPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        adSpaceRevenueJPanel.setLayout(new java.awt.BorderLayout());

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        viewAdSpaceDetailsJButton.setText("View/Edit Ad Space Detils");
        viewAdSpaceDetailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdSpaceDetailsJButtonActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(adSpaceRevenueJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewAdSpaceDetailsJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewAdSpaceJButton)))
                .addContainerGap(630, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewAdSpaceDetailsJButton)
                        .addComponent(viewAdSpaceJButton))
                    .addComponent(backJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adSpaceRevenueJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewAdSpaceDetailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdSpaceDetailsJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = publisherPerformanceJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Ad Space.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AdSpace adSpace= (AdSpace) publisherPerformanceJTable.getValueAt(selectedRow, 0);

        ViewEditAdSpaceDetailsJPanel vasdjp = new ViewEditAdSpaceDetailsJPanel(userProcessContainer,adSpace);
        userProcessContainer.add("ViewAdSpaceDetailsJPanel", vasdjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_viewAdSpaceDetailsJButtonActionPerformed

    private void viewAdSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdSpaceJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = publisherPerformanceJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Ad Space.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        AdSpace adSpace= (AdSpace) publisherPerformanceJTable.getValueAt(selectedRow, 0);

        ViewAdSpaceJPanel vasjp = new ViewAdSpaceJPanel(userProcessContainer,adSpace);
        userProcessContainer.add("ViewAdSpaceJPanel", vasjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdSpaceJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adSpaceRevenueJPanel;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable publisherPerformanceJTable;
    private javax.swing.JButton viewAdSpaceDetailsJButton;
    private javax.swing.JButton viewAdSpaceJButton;
    // End of variables declaration//GEN-END:variables
}
