/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CitizenRole;

import Business.DataStore;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WaterSupplyWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import userinterface.CivilEngineerRole.CivilEngineerWorkAreaJPanel;
import userinterface.WaterSupplyEngineerRole.ViewDetailsAreaJPanel;
  


    


/**
 *
 * @author vedan
 */
public class CitizenWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CitizenWorkAreaJPanel
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    Organization organization;
    EcoSystem system; 
    Network network;
    
    public CitizenWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        //this.organization = organization;
        this.system = business;
        this.network = account.getNetwork();
        
        welcomeTxt.setText("Hello "+ account.getUsername());
        welcomeTxt1.setText("Your City is "+ network.getName());
        
        //jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource()); 
        
        populateRequestTable();
        populateComboBox();
        
    }
    
    
        

    public void populateComboBox()
    {
        for(Network n:system.getNetworkList()){
            
            if( n == network)
            {
                for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList())
                {
                    jb.addItem(e);
                }
            }
        }
    }
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            //String result = ((LabTestWorkRequest) request).getTestResult();
            //row[3] = result == null ? "Waiting" : result;
            row[3] = request.getResult2();
            row[4] = request.getRequestDate();
            if(request.getResolveDate()!=null){
                row[5] = request.getResolveDate();
            }
            else {
                row[5] = "Not Yet Complete";
            }
            
            model.addRow(row);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jb = new javax.swing.JComboBox();
        trafficpolicerequestbutton = new javax.swing.JButton();
        roadRepairRequestButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        welcomeTxt = new javax.swing.JLabel();
        welcomeTxt1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 248, 242));
        setMinimumSize(new java.awt.Dimension(800, 700));
        setPreferredSize(new java.awt.Dimension(1200, 800));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result", "Request Date", "Resolve Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane2.setViewportView(workRequestJTable);

        jb.setOpaque(false);
        jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionPerformed(evt);
            }
        });

        trafficpolicerequestbutton.setBackground(new java.awt.Color(236, 187, 97));
        trafficpolicerequestbutton.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        trafficpolicerequestbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/traffic.png"))); // NOI18N
        trafficpolicerequestbutton.setText("  Traffic Police Request");
        trafficpolicerequestbutton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        trafficpolicerequestbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trafficpolicerequestbuttonMouseEntered(evt);
            }
        });
        trafficpolicerequestbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trafficpolicerequestbuttonActionPerformed(evt);
            }
        });

        roadRepairRequestButton.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        roadRepairRequestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/road-drill.png"))); // NOI18N
        roadRepairRequestButton.setText("Road Repair");
        roadRepairRequestButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        roadRepairRequestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                roadRepairRequestButtonMouseEntered(evt);
            }
        });
        roadRepairRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roadRepairRequestButtonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(108, 180, 242));
        jButton4.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/water.png"))); // NOI18N
        jButton4.setText("Water Issue");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(232, 159, 68));
        jButton5.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/street-light.png"))); // NOI18N
        jButton5.setText("Street Light Not Working");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 48)); // NOI18N
        jLabel1.setText("Raise Complaints");

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel2.setText("Status Of Your Request");

        welcomeTxt.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        welcomeTxt1.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jb, 0, 191, Short.MAX_VALUE)
                                    .addComponent(welcomeTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(trafficpolicerequestbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(roadRepairRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(welcomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(welcomeTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trafficpolicerequestbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roadRepairRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(81, 81, 81)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void trafficpolicerequestbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trafficpolicerequestbuttonActionPerformed
        // TODO add your handling code here:
       Enterprise temp = null;
         for(Network n:system.getNetworkList()){
            if(n == network){
                //Step 2.a: check against each enterprise
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                    
                    if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.LawEnforcement))
                    {
//                        textArea.append("\n"+ e.getName()+"\n");
                        temp = e;
                        break;
                    }
                        //jTextArea1.append(e.getName());
                }}
        }
         
        if(temp!=null)
        {
            if(temp.getOrganizationDirectory().getOrganizationList().size()==0)
            {JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Please try again later. ");
                    return;}
            
            
            for(Organization o : temp.getOrganizationDirectory().getOrganizationList())
            {
                System.out.println(o.getName());
                if(o.getName().equals("Traffic Organization"))
                {
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    userProcessContainer.add("RequestTrafficPoliceJPanel", new RequestTrafficPoliceJPanel(userProcessContainer, account, temp, "Traffic Organization"));
                    layout.next(userProcessContainer);
                    return;
                }

            }
            JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Organization may not have been initialized yetPlease try again later. ");
            return;

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Enterprise may not have been initialized yet. Please try again later. ");
        }
    }//GEN-LAST:event_trafficpolicerequestbuttonActionPerformed

    private void trafficpolicerequestbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trafficpolicerequestbuttonMouseEntered
        // TODO add your handling code here:
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                trafficpolicerequestbutton.setCursor(cursor);
    }//GEN-LAST:event_trafficpolicerequestbuttonMouseEntered

    private void roadRepairRequestButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roadRepairRequestButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_roadRepairRequestButtonMouseEntered

    private void roadRepairRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roadRepairRequestButtonActionPerformed
        // TODO add your handling code here:
        Enterprise temp = null;
         for(Network n:system.getNetworkList()){
            if(n == network){
                //Step 2.a: check against each enterprise
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                    
                    if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Municipal))
                    {
//                        textArea.append("\n"+ e.getName()+"\n");
                        temp = e;
                        break;
                    }
                        //jTextArea1.append(e.getName());
                }}
        }
         
        if(temp!=null)
        {
            if(temp.getOrganizationDirectory().getOrganizationList().size()==0)
            {JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Please try again later. ");
                    return;}
            
            
            for(Organization o : temp.getOrganizationDirectory().getOrganizationList())
            {
                System.out.println(o.getName());
                if(o.getName().equals("Public Works Organization"))
                {
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    userProcessContainer.add("CivilEngineerRole", new RequestRoadRepairJPanel(userProcessContainer, account, temp, "Public Works Organization"));
                    layout.next(userProcessContainer);
                    return;
                }

            }
            JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Organization may not have been initialized yetPlease try again later. ");
            return;
            
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Enterprise may not have been initialized yet. Please try again later. ");
        }
        
    }//GEN-LAST:event_roadRepairRequestButtonActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Enterprise temp = null;
         for(Network n:system.getNetworkList()){
            if(n == network){
                //Step 2.a: check against each enterprise
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                    
                    if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Municipal))
                    {
//                        textArea.append("\n"+ e.getName()+"\n");
                        temp = e;
                        break;
                    }
                        //jTextArea1.append(e.getName());
                }}
        }
         
        if(temp!=null)
        {
            if(temp.getOrganizationDirectory().getOrganizationList().size()==0)
            {JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Please try again later. ");
                    return;}
            
            
            for(Organization o : temp.getOrganizationDirectory().getOrganizationList())
            {
                System.out.println(o.getName());
                if(o.getName().equals("Water Management Organization"))
                {
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    userProcessContainer.add("CivilEngineerRole", new RequestWaterSupplyJPanel(userProcessContainer, account, temp, "Water Management Organization"));
                    layout.next(userProcessContainer);
                    return;
                }

            }
            JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Organization may not have been initialized yetPlease try again later. ");
            return;
            
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Enterprise may not have been initialized yet. Please try again later. ");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Enterprise temp = null;
         for(Network n:system.getNetworkList()){
            if(n == network){
                //Step 2.a: check against each enterprise
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                    
                    if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Municipal))
                    {
//                        textArea.append("\n"+ e.getName()+"\n");
                        temp = e;
                        break;
                    }
                        //jTextArea1.append(e.getName());
                }}
        }
         
        if(temp!=null)
        {
            if(temp.getOrganizationDirectory().getOrganizationList().size()==0)
            {JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Please try again later. ");
                    return;}
            
            
            for(Organization o : temp.getOrganizationDirectory().getOrganizationList())
            {
                System.out.println(o.getName());
                if(o.getName().equals("Power Supply Organization"))
                {
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    userProcessContainer.add("CivilEngineerRole", new RequestStreetLightJPanel(userProcessContainer, account, temp, "Power Supply Organization"));
                    layout.next(userProcessContainer);
                    return;
                }

            }
            JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Organization may not have been initialized yetPlease try again later. ");
            return;
            
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Oops! It looks the system is not ready to handle this request. Enterprise may not have been initialized yet. Please try again later. ");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionPerformed

    }//GEN-LAST:event_jbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jb;
    private javax.swing.JButton roadRepairRequestButton;
    private javax.swing.JButton trafficpolicerequestbutton;
    private javax.swing.JLabel welcomeTxt;
    private javax.swing.JLabel welcomeTxt1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}