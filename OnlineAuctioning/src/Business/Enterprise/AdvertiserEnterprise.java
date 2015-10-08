/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Advertiser.Advertisement.AdvertisementDirectory;
import Business.Advertiser.DemandSidePlatform.DSPDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class AdvertiserEnterprise extends Enterprise {

    private AdvertisementDirectory adInventory;
    private DSPDirectory dspDirectory;
    public AdvertiserEnterprise(String name, EnterpriseType type)
    {
        super(name,type);
        adInventory= new AdvertisementDirectory();
        dspDirectory=new DSPDirectory();
    }

    public AdvertisementDirectory getAdInventory() {
        return adInventory;
    }

    public void setAdInventory(AdvertisementDirectory adInventory) {
        this.adInventory = adInventory;
    }

    public DSPDirectory getDspDirectory() {
        return dspDirectory;
    }

    public void setDspDirectory(DSPDirectory dspDirectory) {
        this.dspDirectory = dspDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
