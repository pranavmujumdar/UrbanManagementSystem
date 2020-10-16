/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        
        if(type.getValue().equals(Type.Cop.getValue())){
            organization = new CopOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.TrafficCop.getValue())){
            organization = new TrafficCopOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.WasteManagement.getValue())){
            organization = new WasteManagementOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.WaterMangement.getValue())){
            organization = new WaterManagementOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.PowerSupply.getValue())){
            organization = new PowerDepartmentOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.PublicWorks.getValue())){
            organization = new PublicWorksOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Inventory.getValue())){
            organization = new InventoryOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Finance.getValue())){
            organization = new FinanceOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public void deleteOrganization(Organization org){
        
        organizationList.remove(org);
    }
    
}