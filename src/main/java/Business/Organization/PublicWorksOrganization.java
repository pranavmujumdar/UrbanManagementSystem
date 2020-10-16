/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CivilEngineerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pranav
 */
public class PublicWorksOrganization extends Organization{
    public PublicWorksOrganization() {
        super(Organization.Type.PublicWorks.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CivilEngineerRole());
        return roles;
    }
}
