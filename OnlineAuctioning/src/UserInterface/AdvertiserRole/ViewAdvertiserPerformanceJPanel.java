/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdvertiserRole;

import Business.Advertiser.Advertisement.Advertisement;
import Business.Advertiser.Organizations.AdvertiserAccountManagerOrganization;
import Business.Enterprise.AdvertiserEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Publisher.WorkRequests.RequestPaymentWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.Advertiser.AdInventoryManagerRole.ViewAdvertisementJPanel;
import UserInterface.Advertiser.AdInventoryManagerRole.ViewEditAdDetailsJPanel;
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
public class ViewAdvertiserPerformanceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAdvertiserPerformanceJPanel
     */
    private OrganizationDirectory organizationDirectory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private AdvertiserEnterprise adEnterprise;
    DefaultCategoryDataset advClickCountDataset=new DefaultCategoryDataset();
    DefaultCategoryDataset advMoneySpentDataset=new DefaultCategoryDataset();
    public ViewAdvertiserPerformanceJPanel(JPanel userProcessContainer,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise=enterprise;
        this.adEnterprise=(AdvertiserEnterprise)enterprise;
        this.organizationDirectory = enterprise.getOrganizationDirectory();
        populatePerformanceTable();
    }
    
    private void populatePerformanceTable()
    {
        DefaultTableModel dtm= (DefaultTableModel) advPerformanceJTable.getModel();
        dtm.setRowCount(0);
        for(Advertisement advertisement: adEnterprise.getAdInventory().getAdvertimentsList())
        {
            if(advertisement.isReady())
            {
                Object row[]=new Object[3];
                row[0]=advertisement;
                row[1]=advertisement.getClickCount();
                double moneySpent=getAdMoneySpent(advertisement);
                row[2]=moneySpent;
                dtm.addRow(row);

                advClickCountDataset.addValue(advertisement.getClickCount(), "Click Count", advertisement.getTitle());
                advMoneySpentDataset.addValue(moneySpent, "Money Spent",advertisement.getTitle());
            }
        }
        createCharts();
    }
    
    private double getAdMoneySpent(Advertisement advertisement)
    {
        Organization organization=null;
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof AdvertiserAccountManagerOrganization)
            {
                organization=org;
                break;
            }
        }
        
        double moneySpent=0;
        for(WorkRequest wr: organization.getWorkQueue().getWorkRequestList())
        {
            if(wr instanceof RequestPaymentWorkRequest)
            {
                RequestPaymentWorkRequest myWorkRequest= (RequestPaymentWorkRequest)wr;
                if(myWorkRequest.getAdName().equals(advertisement.getTitle()) && myWorkRequest.isPaid())
                {
                    moneySpent=moneySpent+myWorkRequest.getAmount();
                }
                
            }
        }
        return moneySpent;
    }
    
        private void createCharts()
    {
        /*Click Count*/
        JFreeChart advClickCountChart= ChartFactory.createBarChart3D("Performance By Click Count", "Advertisement", "Click Count", advClickCountDataset, PlotOrientation.VERTICAL, true, false, false);
        advClickCountChart.setBackgroundPaint(Color.white);
        CategoryPlot advClickCountChartPlot = advClickCountChart.getCategoryPlot();
        advClickCountChartPlot.setBackgroundPaint(Color.lightGray);    
        
        CategoryAxis advClickCountDomainAxis = advClickCountChartPlot.getDomainAxis();
        advClickCountDomainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        NumberAxis advClickCountRangeAxis = (NumberAxis) advClickCountChartPlot.getRangeAxis();
        advClickCountRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        ChartPanel advClickCountChartPanel= new ChartPanel(advClickCountChart);
        advClickCountJPanel.setPreferredSize(new Dimension(300,400));
        advClickCountJPanel.add(advClickCountChartPanel);
        advClickCountJPanel.validate();
        advClickCountJPanel.setVisible(true);

        /*Money Spent*/
        JFreeChart advMoneySpentChart= ChartFactory.createBarChart3D("Performance By Money Spent", "Advertisement", "Money Spent", advMoneySpentDataset, PlotOrientation.VERTICAL, true, false, false);
        advMoneySpentChart.setBackgroundPaint(Color.white);
        CategoryPlot advMoneySpentChartPlot = advMoneySpentChart.getCategoryPlot();
        advMoneySpentChartPlot.setBackgroundPaint(Color.lightGray);
        
        CategoryAxis advMoneySpentDomainAxis = advMoneySpentChartPlot.getDomainAxis();
        advMoneySpentDomainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        NumberAxis advMoneySpentRangeAxis = (NumberAxis) advMoneySpentChartPlot.getRangeAxis();
        advMoneySpentRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());     
        
        ChartPanel advMoneySpentChartPanel= new ChartPanel(advMoneySpentChart);
        advMoneySpentChartPanel.setPreferredSize(new Dimension(300,400));
        advMoneySpentJPanel.add(advMoneySpentChartPanel);
        advMoneySpentJPanel.validate();
        advMoneySpentJPanel.setVisible(true);
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
        advPerformanceJTable = new javax.swing.JTable();
        advClickCountJPanel = new javax.swing.JPanel();
        advMoneySpentJPanel = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();
        viewAdvertisementJJButton = new javax.swing.JButton();
        viewAdJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Advertiser Performance");

        advPerformanceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Advertisement", "Click Count", "Money Spent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(advPerformanceJTable);

        advClickCountJPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        advClickCountJPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        advClickCountJPanel.setLayout(new java.awt.BorderLayout());

        advMoneySpentJPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        advMoneySpentJPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        advMoneySpentJPanel.setLayout(new java.awt.BorderLayout());

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        viewAdvertisementJJButton.setText("View Advertisement");
        viewAdvertisementJJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdvertisementJJButtonActionPerformed(evt);
            }
        });

        viewAdJButton.setText("View/Edit Ad Detils");
        viewAdJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdJButtonActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(advClickCountJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(advMoneySpentJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewAdJButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewAdvertisementJJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewAdJButton)
                    .addComponent(backJButton)
                    .addComponent(viewAdvertisementJJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advClickCountJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advMoneySpentJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewAdvertisementJJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdvertisementJJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = advPerformanceJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Advertisement.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Advertisement advertisement= (Advertisement) advPerformanceJTable.getValueAt(selectedRow, 0);
        ViewAdvertisementJPanel vijp = new ViewAdvertisementJPanel(userProcessContainer,advertisement);
        userProcessContainer.add("ViewImageJPanel", vijp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdvertisementJJButtonActionPerformed

    private void viewAdJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = advPerformanceJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Advertisement.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Advertisement advertisement= (Advertisement) advPerformanceJTable.getValueAt(selectedRow, 0);

        ViewEditAdDetailsJPanel vadjp = new ViewEditAdDetailsJPanel(userProcessContainer,advertisement);
        userProcessContainer.add("ViewAdvertisementDetailsJPanel", vadjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel advClickCountJPanel;
    private javax.swing.JPanel advMoneySpentJPanel;
    private javax.swing.JTable advPerformanceJTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewAdJButton;
    private javax.swing.JButton viewAdvertisementJJButton;
    // End of variables declaration//GEN-END:variables
}
