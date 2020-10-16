/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InventoryMgr;

import userinterface.CivilEngineerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MunicipalEnterprise;
import Business.Inventory.InventoryItem;
import Business.Organization.FinanceOrganization;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.Organization.PublicWorksOrganization;
import Business.Organization.TrafficCopOrganization;
import Business.UserAccount.UserAccount;
import Business.Validation.Validation;
import Business.WorkQueue.FinanceWorkRequest;
import Business.WorkQueue.InventoryWorkRequest;
import Business.WorkQueue.RoadConstructionWorkRequest;
import Business.WorkQueue.WorkRequest;
import Validator.Validate;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vedan
 */
public class RequestFinanceTeamJPanel extends javax.swing.JPanel {

    InventoryWorkRequest request;
    JPanel userProcessContainer;
    UserAccount account; 
    Organization organization;
    Enterprise enterprise; 
    EcoSystem system;
    //RoadConstructionWorkRequest request;
    /**
     * Creates new form JPanel
     */
    public RequestFinanceTeamJPanel(JPanel userProcessContainer, UserAccount account, InventoryOrganization organization, Enterprise enterprise, EcoSystem system, InventoryWorkRequest req) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        this.request = req;
                
        System.out.println("Request after "+request.getSender().getUsername());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bitumenQuantity = new javax.swing.JTextField();
        tarQuantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        asphaltQuantity = new javax.swing.JTextField();
        concreteQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cementQuantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(251, 248, 242));

        jLabel2.setText("Asphalt : ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_send_black_24dp.png"))); // NOI18N
        jButton1.setText("Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Cement : ");

        jLabel4.setText("Concrete : ");

        jLabel5.setText("Bitumen : ");

        jLabel6.setText("Tar : ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Send Request to Finance Team");

        jLabel7.setText("Description : ");

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        jButton2.setBackground(new java.awt.Color(254, 254, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_arrow_back_black_24dp.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(asphaltQuantity)
                                .addComponent(cementQuantity)
                                .addComponent(concreteQuantity)
                                .addComponent(tarQuantity)
                                .addComponent(bitumenQuantity)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(asphaltQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cementQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(concreteQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bitumenQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tarQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addComponent(jLabel7))
                .addContainerGap(345, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
        FinanceWorkRequest newrequest = new FinanceWorkRequest();
        
        //MunicipalEnterprise e = (MunicipalEnterprise) enterprise;
        
        String asphalt =asphaltQuantity.getText();
        String cement = cementQuantity.getText();
        String concrete =concreteQuantity.getText();
        String bitumen = bitumenQuantity.getText();
        String tar = tarQuantity.getText();
        
        
        if(!(Validation.isInt(asphalt))
                && Validation.isInt(cement)
                && Validation.isInt(concrete)
                && Validation.isInt(bitumen)
                && Validation.isInt(tar))
        {
            JOptionPane.showMessageDialog(null,"Invalid input. Please try again!");
            return;
        }
        
//        if(Validate.quantityPatternCorrect(asphalt) && Validate.quantityPatternCorrect(cement) && Validate.quantityPatternCorrect(concrete)
//                && Validate.quantityPatternCorrect(bitumen) && Validate.quantityPatternCorrect(tar))
//        
        
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof FinanceOrganization){
                org = organization;
                break;
            }
        }
        
        if (org!=null){
            
        newrequest.addToList("Asphalt", Integer.parseInt(asphaltQuantity.getText()));
        newrequest.addToList("Cement", Integer.parseInt(cementQuantity.getText()));
        newrequest.addToList("Concrete", Integer.parseInt(concreteQuantity.getText()));
        newrequest.addToList("Bitumen", Integer.parseInt(bitumenQuantity.getText()));
        newrequest.addToList("Tar", Integer.parseInt(tarQuantity.getText()));
        
        
        WorkRequest grandfather = request.getParent();
        newrequest.setParent(request);
        grandfather.setStatus("Waiting for Finance team approval");
        newrequest.setSender(account);
        newrequest.setStatus("Sent");
        newrequest.setMessage(ta.getText());
        
        account.getWorkQueue().getProcessingWorkList().add(request);
        
        List<WorkRequest> list = request.getDependencies();
        list.add(newrequest);
        request.setDependencies(list);
        request.setReceiver(null);
        request.setStatus("Sent");
            
        org.getWorkQueue().getWorkRequestList().add(newrequest);
        account.getWorkQueue().getWorkRequestList().add(newrequest);
        
        }        
        
     
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        InventoryMgrWorkAreaJPanel dwjp = (InventoryMgrWorkAreaJPanel) component;
        dwjp.populateTable();
        dwjp.populateInventoryTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asphaltQuantity;
    private javax.swing.JTextField bitumenQuantity;
    private javax.swing.JTextField cementQuantity;
    private javax.swing.JTextField concreteQuantity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta;
    private javax.swing.JTextField tarQuantity;
    // End of variables declaration//GEN-END:variables
}