/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.WasteCollectorRole;
import java.util.ArrayList;

/**
 *
 * @author pranav
 */
public class WasteManagementOrganization extends Organization{
    public WasteManagementOrganization() {
        super(Organization.Type.WasteManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WasteCollectorRole());
        return roles;
    }
}
