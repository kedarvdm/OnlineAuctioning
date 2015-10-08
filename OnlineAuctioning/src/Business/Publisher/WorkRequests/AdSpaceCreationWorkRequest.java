/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.WorkRequests;

import Business.Publisher.AdSpace.AdSpace;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Sonam
 */
public class AdSpaceCreationWorkRequest extends WorkRequest {
    private AdSpace adSpace;

    public AdSpace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(AdSpace adSpace) {
        this.adSpace = adSpace;
    }
    
}
