/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private UserAccount assigned; 
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String result2;
    private String imgLocation;
    
    private WorkRequest parent;

    public WorkRequest getParent() {
        return parent;
    }

    public void setParent(WorkRequest parent) {
        this.parent = parent;
    }
    
    
    private List<WorkRequest> dependencies;

    public List<WorkRequest> getDependencies() {
        if(dependencies == null)
        {
            return new ArrayList<WorkRequest>();
        }
        
        return dependencies;
    }

    public void setDependencies(List<WorkRequest> dependencies) {
        this.dependencies = dependencies;
    }
    

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }

    public void setAssigned(UserAccount assigned) {
        this.assigned = assigned;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public UserAccount getAssigned() {
        return assigned;
    }

    public String getResult2() {
        return result2;
    }
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    @Override
    public String toString(){
        return this.message;
    }
}
