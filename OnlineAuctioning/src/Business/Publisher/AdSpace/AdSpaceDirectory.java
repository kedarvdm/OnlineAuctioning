/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.AdSpace;

import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class AdSpaceDirectory {
    
    private ArrayList<AdSpace> adSpaceList;
    
    public AdSpaceDirectory()
    {
        adSpaceList= new ArrayList<>();
    }

    public ArrayList<AdSpace> getAdSpaceList() {
        return adSpaceList;
    }

    public void setAdSpaceList(ArrayList<AdSpace> adSpaceList) {
        this.adSpaceList = adSpaceList;
    }
    
    public AdSpace createAndAddAdSpace()
    {
        AdSpace adSpace= new AdSpace();
        adSpaceList.add(adSpace);
        return adSpace;
    }
    
    public void removeAdpace(AdSpace adSpace)
    {
        adSpaceList.remove(adSpace);
    }
    
}
