/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.WorkRequests;

import Business.Advertiser.Advertisement.Advertisement;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Sonam
 */
public class AdCreationWorkRequest extends WorkRequest {
    private Advertisement advertisement;

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
