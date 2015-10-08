/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher;

import Business.Network.Network;
import Business.Organization.OrganizationDirectory;
import Business.Person.Person;
import Business.Publisher.AdSpace.AdSpaceDirectory;

/**
 *
 * @author Sonam
 */
public class Publisher extends Person{
    private static int count=0;
    private int publisherID;
    private AdSpaceDirectory adInventory;
    private OrganizationDirectory publisherOrganizationList;
    private Network network;
    
    public Publisher()
    {
        count++;
        publisherID=count;
        adInventory= new AdSpaceDirectory();
        publisherOrganizationList= new OrganizationDirectory();
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public AdSpaceDirectory getAdInventory() {
        return adInventory;
    }

    public void setAdInventory(AdSpaceDirectory adInventory) {
        this.adInventory = adInventory;
    }

    public OrganizationDirectory getPublisherOrganizationList() {
        return publisherOrganizationList;
    }

    public void setPublisherOrganizationList(OrganizationDirectory publisherOrganizationList) {
        this.publisherOrganizationList = publisherOrganizationList;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
}
