/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InventoryMgr;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MunicipalEnterprise;
import Business.Inventory.InventoryItem;
import Business.Network.Network;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InventoryWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vedan
 */
public class ViewRequestDetailsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private InventoryOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private InventoryWorkRequest request;
    private EcoSystem system;
    private Network network;
    MunicipalEnterprise mp;
    /**
     * Creates new form ViewRequestDetailsJPanel
     */
    public ViewRequestDetailsJPanel(JPanel userProcessContainer, InventoryWorkRequest workRequest, Enterprise enterprise, UserAccount userAccount, EcoSystem system) {
        this.request = workRequest;
        this.enterprise = enterprise;
        this.system =system;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        
        initComponents();
        setButtons();
        populateLabels();
        populateRequestTable();
    }
    
    public void setButtons()
    {
        if(request.getStatus().equals("Completed"))
        {
            approveBtn.setEnabled(false);
            declineBtn.setEnabled(false);
        }
    }
    
    public void populateLabels()
    {
        senderLabel.setText(request.getSender().getUsername());
        if(request.getReceiver()!=null)
        {
            receiverLabel.setText(request.getReceiver().getUsername());
        }
        
        message.setText(request.getMessage());
        statusLabel.setText(request.getStatus());
    }
    
    public void populateRequestTable()
    {
        
        DefaultTableModel model = (DefaultTableModel)reqTable.getModel();
        model.setRowCount(0);
        
        try
        {
        for(InventoryItem item : request.getItemsRequired()){
            
            Object[] row = new Object[2];
            
            //InventoryWorkRequest req = (InventoryWorkRequest) request;
            
            row[0] = item.getItemName();
            row[1] = item.getQuantity();
            
            model.addRow(row);
        }}
        catch(Exception e)
        {
            System.out.println("Cant populate table");
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        senderLabel = new javax.swing.JLabel();
        receiverLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reqTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        approveBtn = new javax.swing.JButton();
        declineBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 248, 242));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel2.setText("Sender : ");

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel3.setText("Receiver : ");

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel1.setText("Message : ");

        message.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        message.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        senderLabel.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        receiverLabel.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        reqTable.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        reqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name ", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reqTable);

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_arrow_back_black_24dp.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        approveBtn.setBackground(new java.awt.Color(143, 226, 125));
        approveBtn.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        approveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_check_black_24dp.png"))); // NOI18N
        approveBtn.setText("Approve");
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });

        declineBtn.setBackground(new java.awt.Color(251, 248, 242));
        declineBtn.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        declineBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_highlight_off_black_24dp.png"))); // NOI18N
        declineBtn.setText("Decline");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel4.setText("Status : ");

        statusLabel.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(receiverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(senderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(143, 143, 143)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(646, 646, 646))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(approveBtn)
                                .addGap(349, 349, 349)
                                .addComponent(declineBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(232, 232, 232))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(senderLabel)
                        .addComponent(jLabel4)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(receiverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveBtn)
                    .addComponent(declineBtn))
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(98, 98, 98))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        InventoryMgrWorkAreaJPanel dwjp = (InventoryMgrWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        // TODO add your handling code here:
        //System.out.println(request.getAssigned()!=userAccount);
        
        if(request.getReceiver()!= userAccount)
        {
            JOptionPane.showMessageDialog(null, "This service is not assigned to you");
            return;
        }
        
        
        boolean flag = true; 
        try
        {
            for(InventoryItem item : request.getItemsRequired())
            {
                for(InventoryItem eitem : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList())
                {
                    if(item.getItemName().equals(eitem.getItemName()))
                    {
                        if(item.getQuantity()> eitem.getQuantity())
                            flag = false;
                    }
                }
            }
            
            if(flag)
            {
                System.out.println("Inside flag loop");
                for(InventoryItem item : request.getItemsRequired())
            {
                for(InventoryItem eitem : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList())
                {
                    if(item.getItemName().equals(eitem.getItemName()))
                    {
                        int temp = eitem.getQuantity();
                        eitem.setQuantity(temp - item.getQuantity());
                    }
                    
                }
            }
                
                request.setStatus("Complete");             
                //organization.getWorkQueue().deleteWorkRequest(request);
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Not enough materials for the job. Please raise a request with the finance team.");
            }
            
        }
        
        catch(Exception e)
        {
            System.out.println("Item not found");
        }
        
    }//GEN-LAST:event_approveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBtn;
    private javax.swing.JButton declineBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel message;
    private javax.swing.JLabel receiverLabel;
    private javax.swing.JTable reqTable;
    private javax.swing.JLabel senderLabel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}