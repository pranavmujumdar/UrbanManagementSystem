/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WaterSupplyEngineerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.TrafficCopOrganization;
import Business.Organization.WaterManagementOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TrafficWorkRequest;
import Business.WorkQueue.WaterSupplyWorkRequest;
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
    private WaterSupplyWorkRequest request;
    private static String product = "";
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private UserAccount userAccount;
    private Enterprise enterprise;
    private EcoSystem system;
    private Network network;
    /**
     * Creates new form ViewDetailsAreaJPanel
     */
//    public ViewDetailsAreaJPanel() {
//        initComponents();
//    }

    ViewDetailsAreaJPanel(JPanel userProcessContainer, WaterSupplyWorkRequest request, UserAccount userAccount, Enterprise enterprise, EcoSystem system, Network network) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.system = system;
        this.network = network;
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
        
        String newname = randomAlphaNumeric(5);
        
        DbxDownloader<FileMetadata> downloader = client.files().download(webPath);        
        
        try {
            
            newname = newname + "." + getExtensionByGuava(webPath);
//           File file = new File(root+newname);
//            FileOutputStream out = new FileOutputStream(newname);
            
            FileOutputStream out = new FileOutputStream(newname);
            downloader.download(out);
            out.close();
        }
            catch (DbxException ex) {
            System.out.println("unable to create a local file for product path "+ newname);
        }
        System.out.println(newname);
        return newname;
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
        jLabel5.setText(request.getMessage());
        jLabel6.setText(request.getSender().toString());
        jLabel7.setText(request.getRequestDate().toString());
//        receiverLabel.setText(request.getReceiver().toString());
        statusLabel.setText(request.getStatus().toString());
//        resolvedLabel.setText(request.getResolveDate().toString());
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
        Image dimg = img.getScaledInstance(240 , 135,Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);
        picLabel.setIcon(imageIcon);
        
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
        jLabel8 = new javax.swing.JLabel();
        picLabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        resultJTextField = new javax.swing.JTextField();
        submitJButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        receiverLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        resolvedLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 248, 242));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel1.setText("Complaint Details");

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel8.setText("Image");

        picLabel.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        picLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        picLabel.setMaximumSize(new java.awt.Dimension(160, 90));
        picLabel.setMinimumSize(new java.awt.Dimension(160, 90));
        picLabel.setPreferredSize(new java.awt.Dimension(160, 90));

        btnBack.setBackground(new java.awt.Color(254, 254, 254));
        btnBack.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_arrow_back_black_24dp.png"))); // NOI18N
        btnBack.setText(" Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel9.setText("Process Request");

        jButton1.setBackground(new java.awt.Color(108, 180, 242));
        jButton1.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jButton1.setText("Request for Traffic Management");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(251, 248, 242));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel10.setText("Notes On Completion");

        resultJTextField.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        submitJButton.setBackground(new java.awt.Color(137, 255, 131));
        submitJButton.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        submitJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_check_black_24dp.png"))); // NOI18N
        submitJButton.setText("Mark As Complete");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(submitJButton)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(251, 248, 242));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel2.setText("Message");

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel3.setText("Sender");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel4.setText("Request Date");

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(44, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(251, 248, 242));

        jLabel11.setText("Receiver");

        jLabel12.setText("Status");

        jLabel13.setText("Resolved Date");

        receiverLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N

        statusLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N

        resolvedLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(receiverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resolvedLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addComponent(receiverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel12)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(resolvedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(jLabel9)))
                .addContainerGap(786, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        WaterSupplyEngineerWorkAreaJPanel1 dwjp = (WaterSupplyEngineerWorkAreaJPanel1) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        File file = new File(product);
        file.delete();
    }//GEN-LAST:event_btnBackActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        request.setTestResult(resultJTextField.getText());
        request.setStatus("Completed");
        request.setReceiver(userAccount);
        //request.setStatus("Pending");
        request.setResult2(resultJTextField.getText());
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date now = new Date();  
        System.out.println(dtf.format(now));
        request.setResolveDate(now);
        JOptionPane.showMessageDialog(null, "Request processed successfully");
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    
        Enterprise temp = null;
        for(Network n:system.getNetworkList()){
            if(n == network){
                //Step 2.a: check against each enterprise
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                    if(e.getName().equals("BPD"))
                    {
                        temp = e;
                        break;
                    }
                    //jTextArea1.append(e.getName());
                }}
            }

            TrafficWorkRequest newrequest = new TrafficWorkRequest();
            newrequest.setMessage(request.getMessage());
            newrequest.setSender(userAccount);
            newrequest.setStatus("sent");

            List<WorkRequest> list = request.getDependencies();
            list.add(newrequest);
            request.setDependencies(list);

            Organization org = null;
            for (Organization organization : temp.getOrganizationDirectory().getOrganizationList()){
                if (organization instanceof TrafficCopOrganization){
                    org = organization;
                    break;
                }
            }

            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(newrequest);
                userAccount.getWorkQueue().getWorkRequestList().add(newrequest);
            }

            if(request.getDependencies().size() > 0)
            {
                request.setStatus("Forwarded");
            }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel picLabel;
    private javax.swing.JLabel receiverLabel;
    private javax.swing.JLabel resolvedLabel;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
