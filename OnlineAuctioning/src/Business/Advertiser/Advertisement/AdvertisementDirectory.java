/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.Advertisement;

import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class AdvertisementDirectory {
     private ArrayList<Advertisement> advertimentsList;
    
    public AdvertisementDirectory()
    {
        advertimentsList= new ArrayList<>();
    }

    public ArrayList<Advertisement> getAdvertimentsList() {
        return advertimentsList;
    }

    public void setAdvertimentsList(ArrayList<Advertisement> advertimentsList) {
        this.advertimentsList = advertimentsList;
    }
    
     public Advertisement createAndAddAdvertisement()
    {
        Advertisement advertisement= new Advertisement();
        advertimentsList.add(advertisement);
        return advertisement;
    }
    
    public void removeAdvertisement(Advertisement advertisement)
    {
        advertimentsList.remove(advertisement);
    }
}
