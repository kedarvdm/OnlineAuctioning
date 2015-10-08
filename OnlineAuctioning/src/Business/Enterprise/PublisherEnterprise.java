/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Publisher.AdSpace.AdSpaceDirectory;
import Business.Publisher.ServerSidePlatform.SSPDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class PublisherEnterprise extends Enterprise {
    private AdSpaceDirectory adSpaceInventory;
    private SSPDirectory sspDirectory;
    public PublisherEnterprise(String name, EnterpriseType type)
    {
        super(name,type);
        adSpaceInventory= new AdSpaceDirectory();
        sspDirectory= new SSPDirectory();
    }

    public AdSpaceDirectory getAdSpaceInventory() {
        return adSpaceInventory;
    }

    public void setAdSpaceInventory(AdSpaceDirectory adSpaceInventory) {
        this.adSpaceInventory = adSpaceInventory;
    }

    public SSPDirectory getSSPDirectory() {
        return sspDirectory;
    }

    public void setSSPDirectory(SSPDirectory sspDirectory) {
        this.sspDirectory = sspDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
