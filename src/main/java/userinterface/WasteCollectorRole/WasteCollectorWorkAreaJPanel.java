/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WasteCollectorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.TrafficCopOrganization;
import Business.Organization.WasteManagementOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TrafficWorkRequest;
import Business.WorkQueue.WasteCollectionWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.db4o.ext.Db4oException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.google.common.io.Files;
import java.awt.CardLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static userinterface.TrafficCopRole.TrafficCopWorkAreaJPanel.getExtensionByGuava;
import userinterface.TrafficCopRole.ViewDetailsAreaJPanel;

/**
 *
 * @author pranav
 */
public class WasteCollectorWorkAreaJPanel extends javax.swing.JPanel {
    WasteManagementOrganization waste;
    UserAccount userAccount;
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem business;
    Network network;
    
     private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * Creates new form WasteCollectorWorkAreaJPanel
     */
    public WasteCollectorWorkAreaJPanel() {
        initComponents();
    }

    public WasteCollectorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, WasteManagementOrganization organization, Enterprise enterprise, EcoSystem system, Network network) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.waste = organization;
        this.enterprise=enterprise;
        this.business=business;
        this.network=network;
        //jLabel2.setText(network.getName());
        populateTable();
        populateUserMsg();
    
    }
    public void populateUserMsg(){
    int ReqNum = 0;
     for(WorkRequest request : waste.getWorkQueue().getWorkRequestList()){
         if(request.getStatus().equalsIgnoreCase("sent")||request.getStatus().equalsIgnoreCase("forwarded")){
             ReqNum = ReqNum+1;
         }
     }

    welcomeLbl.setText("Hi "+userAccount.getEmployee().getName()+" Your organization has "+ReqNum+" open requests!");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : waste.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            row[4] = request.getRequestDate();
            row[5] = request.getResolveDate();
            model.addRow(row);
        }
    }
    
        public static String getExtensionByGuava(String filename) {
    return Files.getFileExtension(filename);
}
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            //String result = ((LabTestWorkRequest) request).getTestResult();
            //row[3] = result == null ? "Waiting" : result;
            row[3] = request.getResult2();
            model.addRow(row);
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        assignBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        viewDetailsBtn = new javax.swing.JButton();
        refereshbtn = new javax.swing.JButton();
        welcomeLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 248, 242));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        valueLabel.setText("<value>");

        assignBtn.setBackground(new java.awt.Color(162, 228, 135));
        assignBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_mode_edit_black_24dp.png"))); // NOI18N
        assignBtn.setText("Assign to me");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        jLabel1.setText("Garbage Collection Requests");

        workRequestJTable.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Request Date", "Resolve Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        viewDetailsBtn.setBackground(new java.awt.Color(108, 180, 242));
        viewDetailsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_search_black_24dp.png"))); // NOI18N
        viewDetailsBtn.setText("View Details");
        viewDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsBtnActionPerformed(evt);
            }
        });

        refereshbtn.setBackground(new java.awt.Color(254, 254, 254));
        refereshbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_refresh_black_24dp.png"))); // NOI18N
        refereshbtn.setText("Referesh");
        refereshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refereshbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(welcomeLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(assignBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewDetailsBtn)
                                .addGap(54, 54, 54))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(refereshbtn)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(welcomeLbl)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refereshbtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewDetailsBtn)
                    .addComponent(assignBtn))
                .addGap(161, 161, 161))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
            
        
        
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row.");            
            return;
        }
        
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        if(request.getReceiver()!=null)
        {
            if(request.getReceiver()==userAccount)
            {
                JOptionPane.showMessageDialog(null, "The selected request is already assigned to you");
                return;
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The selected request is assigned to someone else.");            
                return;
            }
        }
        
        else if(userAccount.getWorkQueue().getWorkRequestList().size()>0)
        {
           // JOptionPane.showMessageDialog(welcomeLbl, "Please process your current assignment before taking on a new request.");
            return;
        }
        else {
                request.setReceiver(userAccount);
                request.setStatus("Pending");
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                populateTable();
                 
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_assignBtnActionPerformed

    private void viewDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsBtnActionPerformed
        // TODO add your handling code here:
         int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow >= 0){
            WasteCollectionWorkRequest request = (WasteCollectionWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
           ViewWasteDetailsAreaJPanel ViewDetailsAreaJPanel = new ViewWasteDetailsAreaJPanel(userProcessContainer, request, userAccount, enterprise, business, network);
            
            //ViewDetailsAreaJPanel ViewDetailsAreaJPanel = new ViewDetailsAreaJPanel(userProcessContainer, request, userAccount, enterprise, business, network);
            userProcessContainer.add("processWorkRequestJPanel", ViewDetailsAreaJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        }
        else{
            JOptionPane.showMessageDialog(null, "select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_viewDetailsBtnActionPerformed

    private void refereshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refereshbtnActionPerformed
        // TODO add your handling code here:
         populateTable();
        
    }//GEN-LAST:event_refereshbtnActionPerformed

    public String download(String webPath) throws Db4oException, IOException, DbxException 
    {
        DbxRequestConfig config = new DbxRequestConfig("sample", "en_US");
        DbxClientV2 client = new DbxClientV2(config, EcoSystem.ACCESS_TOKEN);
        
        String root = "/resources/";
        String newname = randomAlphaNumeric(5);
        DbxDownloader<FileMetadata> downloader = client.files().download(webPath);     
        
        try {
            
            newname = newname + "." + getExtensionByGuava(webPath);
            FileOutputStream out = new FileOutputStream(newname);
            downloader.download(out);
            out.close();
        } 
        catch (DbxException ex) {
            System.out.println("unable to create a local file for product path "+ newname);
        }
        System.out.println(root+newname);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refereshbtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton viewDetailsBtn;
    private javax.swing.JLabel welcomeLbl;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}