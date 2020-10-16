/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Inventory.InventoryItem;
import java.util.ArrayList;

/**
 *
 * @author vedan
 */
public class InventoryWorkRequest extends WorkRequest{
    
    private String testResult;
    
    private ArrayList<InventoryItem> itemsRequired = new ArrayList<InventoryItem>();

    public ArrayList<InventoryItem> getItemsRequired() {
        return itemsRequired;
    }

    public void setItemsRequired(ArrayList<InventoryItem> itemsRequired) {
        this.itemsRequired = itemsRequired;
    }
    
    public ArrayList<InventoryItem> addToList(String name, int quantity)
    {
        InventoryItem item = new InventoryItem();
        item.setItemName(name);
        item.setQuantity(quantity);
        
        itemsRequired.add(item);
        return itemsRequired;
        
    }
    
    
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
}
