/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.WaterSupplyEngineerRole;
import java.util.ArrayList;

/**
 *
 * @author pranav
 */
public class WaterManagementOrganization extends Organization{
    public WaterManagementOrganization() {
        super(Organization.Type.WaterMangement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WaterSupplyEngineerRole());
        return roles;
    }
}
