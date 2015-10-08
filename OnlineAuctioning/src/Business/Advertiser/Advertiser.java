/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser;

import Business.Advertiser.Advertisement.AdvertisementDirectory;
import Business.Organization.OrganizationDirectory;
import Business.Person.Person;

/**
 *
 * @author Sonam
 */
public class Advertiser extends Person {
    private static int count=0;
    private int advertiserID;
    private OrganizationDirectory advertiserOrganizationList;
    private AdvertisementDirectory adInventory;
    
    
    public Advertiser()
    {
        count++;
        advertiserID=count;
        adInventory= new AdvertisementDirectory();
        advertiserOrganizationList= new OrganizationDirectory();
    }

    public int getAdvertiserID() {
        return advertiserID;
    }

    public void setAdvertiserID(int advertiserID) {
        this.advertiserID = advertiserID;
    }

    public AdvertisementDirectory getAdInventory() {
        return adInventory;
    }

    public void setAdInventory(AdvertisementDirectory adInventory) {
        this.adInventory = adInventory;
    }

    public OrganizationDirectory getAdvertiserOrganizationList() {
        return advertiserOrganizationList;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
