/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Inventory.InventoryDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pranav
 */
public class MunicipalEnterprise extends Enterprise{
    
    //private InventoryDirectory inventoryDirectoryEnterpriseLevel;
        
    public MunicipalEnterprise(String name)
    {
        super(name,Enterprise.EnterpriseType.Municipal);
        //inventoryDirectoryEnterpriseLevel = new InventoryDirectory();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    /*
    get EnterpriseDirectory
    */
//    public InventoryDirectory getInventoryDirectoryEnterpriseLevel() {
//        if(inventoryDirectoryEnterpriseLevel==null)
//            return new InventoryDirectory();
//        return this.inventoryDirectoryEnterpriseLevel;
//    }
}
