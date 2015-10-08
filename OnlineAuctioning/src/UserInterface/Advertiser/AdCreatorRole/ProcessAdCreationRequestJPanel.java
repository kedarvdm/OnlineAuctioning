/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Advertiser.AdCreatorRole;

import Business.Advertiser.Advertisement.Advertisement;
import Business.Advertiser.WorkRequests.AdCreationWorkRequest;
import Business.Utils.MyIntegerVerifier;
import Business.Utils.MyStringVerifier;
import UserInterface.Advertiser.AdInventoryManagerRole.ViewAdvertisementJPanel;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sonam
 */
public class ProcessAdCreationRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProcessAdCreationRequestJPanel
     */
    private JPanel userProcessContainer;
    private AdCreationWorkRequest myWorkRequest;
    private String filePath;
    private Advertisement advertisement;
    public ProcessAdCreationRequestJPanel(JPanel userProcessContainer,AdCreationWorkRequest myWorkRequest,String filePath) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.myWorkRequest=myWorkRequest;
        this.filePath=filePath;
        this.advertisement=(Advertisement) myWorkRequest.getAdvertisement();
        setVerifiers();
        populateAdDetails();  
    }

    private void setVerifiers()
    {
        MyStringVerifier myStringVerifier= new MyStringVerifier();
        titleJTextField.setInputVerifier(myStringVerifier);
        MyIntegerVerifier myIntegerVerifier= new MyIntegerVerifier();
        widthJTextField.setInputVerifier(myIntegerVerifier);
        heightJTextField.setInputVerifier(myIntegerVerifier);
    }
    private void populateAdDetails()
    {
        titleJTextField.setText(advertisement.getTitle());
        if(advertisement.getWidth()!=0)
        {
            widthJTextField.setText(String.valueOf(advertisement.getWidth()));
        }
        if(advertisement.getHeight()!=0)
        {    
            heightJTextField.setText(String.valueOf(advertisement.getHeight()));
        }
        imagePathJLabel.setText(advertisement.getLocation());
        adWordsJTextField.setText(advertisement.getAdWords());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titleJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        widthJTextField = new javax.swing.JTextField();
        heightJTextField = new javax.swing.JTextField();
        chooseImageJButton = new javax.swing.JButton();
        imagePathJLabel = new javax.swing.JLabel();
        saveAdJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        adWordsJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        viewAdJButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setText("Title:");

        jLabel2.setText("Width:");

        jLabel3.setText("Height:");

        jLabel4.setText("Image:");

        chooseImageJButton.setText("Choose Image");
        chooseImageJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageJButtonActionPerformed(evt);
            }
        });

        imagePathJLabel.setText("Image Path");

        saveAdJButton.setText("Save Advertisement");
        saveAdJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAdJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("Ad Words:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Create Advertisement");

        viewAdJButton1.setText("View Advertisement");
        viewAdJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAdJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adWordsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(widthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(chooseImageJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(heightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(imagePathJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveAdJButton)
                                .addGap(18, 18, 18)
                                .addComponent(viewAdJButton1)))))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(widthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseImageJButton)
                    .addComponent(imagePathJLabel)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(adWordsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveAdJButton)
                    .addComponent(backJButton)
                    .addComponent(viewAdJButton1))
                .addContainerGap(443, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chooseImageJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImageJButtonActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser chooser = new JFileChooser(userDir +"/Desktop");
        chooser.setAcceptAllFileFilterUsed(false);
        String[] suffices = ImageIO.getReaderFileSuffixes();
        // Add a file filter for each one
        for (int i = 0; i < suffices.length; i++) {
            FileFilter filter = new FileNameExtensionFilter(suffices[i].toUpperCase() + " files", suffices[i]);
            chooser.addChoosableFileFilter(filter);
        }
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal== JFileChooser.APPROVE_OPTION)
        {
            File f= chooser.getSelectedFile();
            String fileName= f.getAbsolutePath();
            imagePathJLabel.setText(fileName);
        }
    }//GEN-LAST:event_chooseImageJButtonActionPerformed

    private void saveAdJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAdJButtonActionPerformed
        // TODO add your handling code here:
        
        if(!validateFields())
        {
            JOptionPane.showMessageDialog(this,"Please enter correct values.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String imagePath= imagePathJLabel.getText();
        String uploadPath=filePath;
        Path p=null;
        try
        {    
            p = Paths.get(imagePath);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"Invalid image path, Cannot save advertisement","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String fileName=p.getFileName().toString();
        uploadPath= uploadPath+"\\";
        checkAndCreateFileSystem(uploadPath);
        uploadPath= uploadPath+fileName;
        
        if(imagePath.equals(uploadPath))
        {
            System.out.println("No change in Advertisement Image, No need to copy again.");
        }
        else
        {
            File source= new File(imagePath);
            File dest= new File(uploadPath);

            try
            {
                copyFileUsingFileStreams(source,dest);
                System.out.println("Image copied to Ad Creators directory");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this,"Error copying the file. Cannot save the advertisement.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        advertisement.setTitle(titleJTextField.getText());
        advertisement.setWidth(Integer.parseInt(widthJTextField.getText()));
        advertisement.setHeight(Integer.parseInt(heightJTextField.getText()));
        advertisement.setDateCreated(new Date());
        advertisement.setLocation(uploadPath);
        advertisement.setAdWords(adWordsJTextField.getText());
        myWorkRequest.setStatus("Completed");
        System.out.println("Advertisement created/updated, Work request status updated");
        populateAdDetails();
        JOptionPane.showMessageDialog(this,"Advertisement added/updated!!","Update",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveAdJButtonActionPerformed

    private Boolean validateFields()
    {
        if(titleJTextField.getText().length()==0
                || widthJTextField.getText().length()==0
                || heightJTextField.getText().length()==0
                || imagePathJLabel.getText()==null
                || adWordsJTextField.getText().length()==0
                || adWordsJTextField.getText().startsWith(" "))
        {
            return false;
        }
        return true;
    }
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewAdJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAdJButton1ActionPerformed
        // TODO add your handling code here:
        if(!myWorkRequest.getStatus().equals("Completed"))
        {
            JOptionPane.showMessageDialog(this,"Please save the Advetisement first.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Advertisement advertisement= myWorkRequest.getAdvertisement();

        ViewAdvertisementJPanel vijp = new ViewAdvertisementJPanel(userProcessContainer,advertisement);
        userProcessContainer.add("ViewImageJPanel", vijp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewAdJButton1ActionPerformed
    private void checkAndCreateFileSystem(String filePath)
    {
        File f= new File(filePath);
        if(!(f.exists() && f.isDirectory()))
        {
            f.mkdirs();
        }
    }
    private static void copyFileUsingFileStreams(File source, File dest) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adWordsJTextField;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton chooseImageJButton;
    private javax.swing.JTextField heightJTextField;
    private javax.swing.JLabel imagePathJLabel;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton saveAdJButton;
    private javax.swing.JTextField titleJTextField;
    private javax.swing.JButton viewAdJButton1;
    private javax.swing.JTextField widthJTextField;
    // End of variables declaration//GEN-END:variables
}
