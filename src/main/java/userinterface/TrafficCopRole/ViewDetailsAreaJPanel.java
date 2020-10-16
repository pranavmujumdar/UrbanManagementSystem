/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.TrafficCopRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.TrafficCopOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TrafficWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.db4o.ext.Db4oException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.google.common.io.Files;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pranav
 */
public class ViewDetailsAreaJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    UserAccount userAccount;
    private TrafficWorkRequest request;
    Enterprise enterprise;
    EcoSystem business;
    Network network;
    
    private static String product = "";
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * Creates new form ViewDetailsAreaJPanel
     */
//    public ViewDetailsAreaJPanel() {
//        initComponents();
//    }

    ViewDetailsAreaJPanel(JPanel userProcessContainer, TrafficWorkRequest request, UserAccount account, Enterprise enterprise, EcoSystem business, Network network) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.enterprise =enterprise;
        this.business=business;
        this.network=network;
        this.userAccount=account;
        populateFields();
    }
    
    /*
    Code for rendering the image in picLabel
    */
    public static String getExtensionByGuava(String filename) {
        return Files.getFileExtension(filename);
    }
    public String download(String webPath) throws Db4oException, IOException, DbxException 
    {
        DbxRequestConfig config = new DbxRequestConfig("sample", "en_US");
        DbxClientV2 client = new DbxClientV2(config, EcoSystem.ACCESS_TOKEN);
        
        //String fileSeparator = System.getProperty("file.separator");
        //System.out.println(fileSeparator);
        
        //String root = "/home/pranav/group2/thebugslayers/Urban/UrbanMaven/resources/";
        
        
        System.out.println(System.getProperty("user.dir"));
        
        String root = System.getProperty("user.dir");
        root = root + "\\" + "resources";
        String newname = randomAlphaNumeric(5);
        DbxDownloader<FileMetadata> downloader = client.files().download(webPath);        
        try {
            
            newname = newname + "." + getExtensionByGuava(webPath);
            root = root + "\\" + newname;
//            File file = new File(root+newname);
//            FileOutputStream out = new FileOutputStream(newname);

            FileOutputStream out = new FileOutputStream(root);
            //FileOutputStream out = new FileOutputStream(newname);
            downloader.download(out);
            out.close();
        } catch (DbxException ex) {
            System.out.println("unable to create a local file for product path "+ root);
        }
        
        System.out.println(root);
        return root;
    }
    
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
        int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
        builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
    /*
    Code to Populate Work request fields and the image
    */
    private void populateFields(){
        messageLabel.setText(request.getMessage());
        senderLabel.setText(request.getSender().toString());
        dateLabel.setText(request.getRequestDate().toString());
        
        if(request.getReceiver()!=null)
        {
            receiverLabel.setText(request.getReceiver().toString());            
        }
        if(request.getResolveDate()!=null)
        {
            resolvedLabel.setText(request.getResolveDate().toString()); 
        }
        if(request.getStatus()!=null)
        {
            statusLabel.setText(request.getStatus());
        }
        resultJTextField.setEnabled(false);
        submitJButton.setEnabled(false);
        
        if(request.getReceiver()!=null)
        {
             if(request.getReceiver()==userAccount)
            {
                if(request.getStatus().equals("Completed"))
                {
                    resultJTextField.setEnabled(false);
                    submitJButton.setEnabled(false);
                }
                else
                {
                    resultJTextField.setEnabled(true);
                    submitJButton.setEnabled(true);
                }
                //processPanel.setEnabled(true);   
                
            }
            else
            {
                resultJTextField.setEnabled(false);
                submitJButton.setEnabled(false);
            }
        }
        
        else if(userAccount.getWorkQueue().getWorkRequestList().size()==0)
        {
                resultJTextField.setEnabled(true);
                submitJButton.setEnabled(true);
        }
        
        if(request.getImgLocation()==null)
        {
            picLabel.setText("No corresponding image for the selected request");
            return;
        }
        
        System.out.println("WEB location "+request.getImgLocation());
//        String product = "";
        try
        {
            product = download(request.getImgLocation());
        }
        catch(Exception e)
        {
            System.out.println("Some issue with downloading");
            
        }
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(product));
            //Image dimg = img.getScaledInstance(picLabel.getWidth(),picLabel.getHeight(),Image.SCALE_SMOOTH);
            
            Image dimg = img.getScaledInstance(160 , 90,Image.SCALE_SMOOTH);
       
            ImageIcon imageIcon = new ImageIcon(dimg);
            picLabel.setIcon(imageIcon);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Unable to find " + product);
        }

        
        /*int labelh = picLabel.getHeight();
        int labelw = picLabel.getWidth();
        int aspectRatio = labelw/labelh;
        
        System.out.println(img.getWidth()+" x " + img.getHeight());
        int imageh = (int) (img.getWidth() / aspectRatio);
        int imagew = (int) (img.getHeight() * aspectRatio);
        
        System.out.println("imageh is "+imageh);*/
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        picLabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        processPanel = new javax.swing.JPanel();
        submitJButton = new javax.swing.JButton();
        resultJTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        senderLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        resolvedLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        receiverLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 248, 242));

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel8.setText("Image (Request)");

        picLabel.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        picLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        picLabel.setMaximumSize(new java.awt.Dimension(160, 90));
        picLabel.setMinimumSize(new java.awt.Dimension(160, 90));
        picLabel.setPreferredSize(new java.awt.Dimension(160, 90));

        btnBack.setBackground(new java.awt.Color(254, 254, 254));
        btnBack.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_arrow_back_black_24dp.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel1.setText("Complaint Details");

        processPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        submitJButton.setBackground(new java.awt.Color(161, 234, 128));
        submitJButton.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        submitJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_check_black_24dp.png"))); // NOI18N
        submitJButton.setText("Process / Mark Completed");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        resultJTextField.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel10.setText("Notes On Completion");

        javax.swing.GroupLayout processPanelLayout = new javax.swing.GroupLayout(processPanel);
        processPanel.setLayout(processPanelLayout);
        processPanelLayout.setHorizontalGroup(
            processPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(resultJTextField)
                .addGap(18, 18, 18)
                .addComponent(submitJButton)
                .addContainerGap())
        );
        processPanelLayout.setVerticalGroup(
            processPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(processPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitJButton))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(251, 248, 242));

        jLabel4.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel4.setText("Request Date");

        jLabel2.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel2.setText("Message : ");

        messageLabel.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        senderLabel.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        dateLabel.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel3.setText("Sender : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(senderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(senderLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateLabel))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(251, 248, 242));

        resolvedLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel5.setText("Receiver : ");

        statusLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel7.setText("Resolved Date : ");

        receiverLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel6.setText("Status : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(receiverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(resolvedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(receiverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resolvedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnBack)
                        .addComponent(picLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                        .addComponent(processPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(401, 401, 401))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(processPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        TrafficCopWorkAreaJPanel dwjp = (TrafficCopWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        File file = new File(product);
        file.delete();
    }//GEN-LAST:event_btnBackActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        
        if(resultJTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(processPanel, "Comments cannot be empty");
            return;
        }
        
        request.setTestResult(resultJTextField.getText());
        request.setStatus("Completed");
        request.setReceiver(userAccount);
        
        
        
        //request.setStatus("Pending");
        //whats the use of this? we aren't displaying result2 anywhere! 
        request.setResult2(resultJTextField.getText());
        
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        System.out.println(dtf.format(now));
        request.setResolveDate(now);
        userAccount.getWorkQueue().getWorkRequestList().remove(request);
        
        JOptionPane.showMessageDialog(null, "Request processed successfully");
        
        resultJTextField.setEnabled(false);
        submitJButton.setEnabled(false);
        populateFields();
        
    }//GEN-LAST:event_submitJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel processPanel;
    private javax.swing.JLabel receiverLabel;
    private javax.swing.JLabel resolvedLabel;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JLabel senderLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
