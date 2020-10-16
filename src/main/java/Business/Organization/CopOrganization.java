/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CopRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pranav
 */
public class CopOrganization extends Organization{
     public CopOrganization() {
        super(Organization.Type.Cop.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CopRole());
        return roles;
    }
}
