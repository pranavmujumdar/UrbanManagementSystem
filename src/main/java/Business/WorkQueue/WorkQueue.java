/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;
    private ArrayList<WorkRequest> processingWorkList;

    public ArrayList<WorkRequest> getProcessingWorkList() {
        return processingWorkList;
    }

    public void setProcessingWorkList(ArrayList<WorkRequest> processingWorkList) {
        this.processingWorkList = processingWorkList;
    }

    public WorkQueue() {
        workRequestList = new ArrayList();
        processingWorkList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    public void deleteWorkRequest(WorkRequest request)
    {
        if(workRequestList.contains(request))
        {
            workRequestList.remove(request);
        }
    }
    
    public void deleteProcessRequest(WorkRequest request)
    {
        if(processingWorkList.contains(request))
        {
            processingWorkList.remove(request);
        }
    }
    
}