 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Inventory.InventoryDirectory;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MyPC1
 */
public abstract class Enterprise extends Organization{
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    private ArrayList<Organization.Type> permittedOrganizations;

    public ArrayList<Type> getPermittedOrganizations() {
        return permittedOrganizations;
    }

    public void setPermittedOrganizations(ArrayList<Type> permittedOrganizations) {
        this.permittedOrganizations = permittedOrganizations;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    private InventoryDirectory inventoryDirectoryEnterpriseLevel;

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public void setInventoryDirectoryEnterpriseLevel(InventoryDirectory inventoryDirectoryEnterpriseLevel) {
        this.inventoryDirectoryEnterpriseLevel = inventoryDirectoryEnterpriseLevel;
    }
    
     public InventoryDirectory getInventoryDirectoryEnterpriseLevel() {
        return this.inventoryDirectoryEnterpriseLevel;
    }
     
    public enum EnterpriseType{
        LawEnforcement("LawEnforcement"),
        Municipal("Municipal Services");
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        
        public String getValue() {
            return value;
        }
        
       /* @Override
        public String toString(){
        return value;
    }*/
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        //System.out.println("Enterprise admin is set now");
        this.enterpriseType = enterpriseType;
    }
    
    public Enterprise(String name,EnterpriseType type){
        super(name);
        this.enterpriseType=type;
        organizationDirectory=new OrganizationDirectory();
        inventoryDirectoryEnterpriseLevel = new InventoryDirectory();
        permittedOrganizations = new ArrayList<Organization.Type>();
        
        
        if(enterpriseType.equals(Enterprise.EnterpriseType.Municipal))
        {
            permittedOrganizations.add(Organization.Type.WaterMangement);
            permittedOrganizations.add(Organization.Type.WasteManagement);
            permittedOrganizations.add(Organization.Type.PublicWorks);
            permittedOrganizations.add(Organization.Type.Inventory);
            permittedOrganizations.add(Organization.Type.PowerSupply);
            permittedOrganizations.add(Organization.Type.Finance);
        }
        
        if(enterpriseType.equals(Enterprise.EnterpriseType.LawEnforcement))
        {
            permittedOrganizations.add(Organization.Type.TrafficCop);
            permittedOrganizations.add(Organization.Type.Cop);                    
        }
        
    }
}
