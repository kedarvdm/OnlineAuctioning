/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        Admin("Admin Organization"),
        
        /*Ad Exchange Organizations*/
        Advertiser("Advertiser Organization"),
        Customer("Customer Organization"),
        Publisher("Publisher Organization"),
        Supplier("Supplier Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum AdvertiserOrganizationType
    {
        /*Advertiser Organizations*/
        AdvertiserAccountManager("Advertiser Account Manager Organization"),
        AdCreator("Ad Creator Organization"),
        AdInventoryManager("Ad Inventory Manager Organization"),
        DSPManager("DSP Manager Organization");
       
        private String value;
        private AdvertiserOrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum PublisherOrganizationType
    {
        /*Advertiser Organizations*/
        PublisherAccountManager("Publisher Account Manager Organization"),
        AdSpaceManager("Ad Space Manager Organization"),
        AdSpaceCreator("Ad Space Creator Organization"),
        SSPManager("SSP Manager Organization");
       
        private String value;
        private PublisherOrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum SupplierOrganizationType
    {
        /*Supplier Organizations*/
        ProductManager("Product Manager Organization"),
        SalesRepresentative("Sales Representative Organization"),
        ShippingSpecialist("Shipping Specialist Organization");
       
        private String value;
        private SupplierOrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    

    public Organization(String name) {
        this.name = name;
        counter++;
        organizationID = counter;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
    }

    public abstract ArrayList<Role> getSupportedRole();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
