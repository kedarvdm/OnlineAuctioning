/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Business;

import Business.AdExchange.Roles.SystemAdminRole;
import Business.Auction.AuctionDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Supplier.MasterOrderCatalog;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class EcoSystem extends Organization{
    private static EcoSystem ecoSystem;
    private ArrayList<Network> networkList;
    private AuctionDirectory auctionDirectory;
    private MasterOrderCatalog masterOrderCatalog;
    
    public static EcoSystem getInstance()
    {
        if(ecoSystem==null)
        {
            ecoSystem= new EcoSystem();
        }
        return ecoSystem;
    }
    
    private EcoSystem()
    {
        super(null);
        networkList= new ArrayList<>();
        auctionDirectory= new AuctionDirectory();
        masterOrderCatalog= new MasterOrderCatalog();
    }

    public static EcoSystem getEcoSystem() {
        return ecoSystem;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
    
    public Network createAndAddNetwork()
    {
        Network network= new Network();
        networkList.add(network);
        return network;
    }

    public AuctionDirectory getAuctionDirectory() {
        return auctionDirectory;
    }

    public void setAuctionDirectory(AuctionDirectory auctionDirectory) {
        this.auctionDirectory = auctionDirectory;
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList= new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    public boolean checkIfUserNameisUnique(String userName)
    {
        if(! this.getUserAccountDirectory().checkIfUserNameUnique(userName))
        {
            return false;
        }
        return true;
    }
}
