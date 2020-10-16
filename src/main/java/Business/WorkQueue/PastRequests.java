/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author vedan
 */
public class PastRequests {
    private ArrayList<WorkRequest> pastRequestList;

    public PastRequests() {
        pastRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getPastRequestList() {
        return pastRequestList;
    }
    
    public void deleteWorkRequest(WorkRequest request)
    {
        if(pastRequestList.contains(request))
        {
            pastRequestList.remove(request);
        }
    }
}
