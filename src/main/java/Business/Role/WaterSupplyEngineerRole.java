/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CopOrganization;
import Business.Organization.Organization;
import Business.Organization.WaterManagementOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CopRole.CopWorkAreaJPanel;
import userinterface.WaterSupplyEngineerRole.WaterSupplyEngineerWorkAreaJPanel1;

/**
 *
 * @author pranav
 */
public class WaterSupplyEngineerRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new WaterSupplyEngineerWorkAreaJPanel1(userProcessContainer, account, (WaterManagementOrganization)organization, enterprise, business, network);
    }
}
