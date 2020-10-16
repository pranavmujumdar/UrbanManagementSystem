/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TrafficCopRole;
import java.util.ArrayList;

/**
 *
 * @author pranav
 */
public class TrafficCopOrganization extends Organization{
    public TrafficCopOrganization() {
        super(Organization.Type.TrafficCop.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TrafficCopRole());
        return roles;
    }
}
