/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.LawEnforcementEnterprise;
import Business.Enterprise.MunicipalEnterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    Enterprise enterprise;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer,OrganizationDirectory directory, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.enterprise = enterprise; 
        populateTable();
        populateCombo();
    }
    
    private void populateCombo(){
        /*
        organizationJComboBox.removeAllItems();
        for (Type type : Organization.Type.values()){
            if (!type.getValue().equals(Type.Admin.getValue()))
                organizationJComboBox.addItem(type);
        }
        System.out.println(Type.Admin.getValue());*/
        
        /*organizationJComboBox.removeAllItems();
        for (Type type : Organization.Type.values()) {

            System.out.println("Comparing"+ type.getValue()+" and "+ Type.Admin.getValue());
            if (!type.getValue().equals(Type.Admin.getValue())) {

                if (enterprise instanceof MunicipalEnterprise) {
                    if (type.getValue().equals(Type.PublicWorks.getValue())) {
                        organizationJComboBox.addItem(type);

                    } else if 
                         (type.getValue().equals(Type.WaterMangement.getValue())) {
                            organizationJComboBox.addItem(type);                        
                    } else if 
                         (type.getValue().equals(Type.WasteManagement.getValue())) {
                            organizationJComboBox.addItem(type);
                    }
                    else if 
                         (type.getValue().equals(Type.Inventory.getValue())) {
                            organizationJComboBox.addItem(type);
                    }
                    else if 
                         (type.getValue().equals(Type.Finance.getValue())) {
                            organizationJComboBox.addItem(type);

                }
                } 
                else if (enterprise instanceof LawEnforcementEnterprise) {

                    if (type.getValue().equals(Type.TrafficCop.getValue())) {
                        organizationJComboBox.addItem(type);

                    } else if (type.getValue().equals(Type.Cop.getValue())) {
                        organizationJComboBox.addItem(type);

                    } 
                }
                //else 
                  //  organizationJComboBox.addItem(type);

            }
        }*/
        
        organizationJComboBox.removeAllItems();
        for (Type type : enterprise.getPermittedOrganizations()){
                organizationJComboBox.addItem(type);
        }
        
        
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : directory.getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization;
            row[1] = organization.getName();
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        organizationJTable.setGridColor(new java.awt.Color(254, 254, 254));
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
            organizationJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        addJButton.setBackground(new java.awt.Color(108, 180, 242));
        addJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_add_box_black_24dp.png"))); // NOI18N
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        organizationJComboBox.setBackground(new java.awt.Color(254, 254, 254));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Organization Type ");

        backJButton.setBackground(new java.awt.Color(254, 254, 254));
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_arrow_back_black_24dp.png"))); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(254, 99, 108));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_highlight_off_black_24dp.png"))); // NOI18N
        jButton1.setText("Remove Organization");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Organizations");

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 48)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_widgets_black_48dp.png"))); // NOI18N
        jLabel3.setText("Manage Organizations");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(backJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(299, 299, 299))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(347, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addJButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(334, 334, 334))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(272, 272, 272))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(110, 110, 110)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addComponent(backJButton)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        Type type = (Type) organizationJComboBox.getSelectedItem();
        
        boolean flag = false;
        for(Organization o : directory.getOrganizationList())
        {
            if(o.getName().equalsIgnoreCase(type.getValue()))
            {
                flag = true;
            }
        }
        
        if(flag)
        {
            JOptionPane.showMessageDialog(null, "Organization "+ type + " already exists.");
            return;
        }
        
        directory.createOrganization(type);
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select an organization to remove");
            return;
        }

        Organization org = (Organization) organizationJTable.getValueAt(selectedRow, 0);

        enterprise.getOrganizationDirectory().deleteOrganization(org);

        populateTable();

        JOptionPane.showMessageDialog(null, org + " removed");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
