/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author Sonam
 */
public abstract class Enterprise extends Organization {
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private Network network;
    
    public Enterprise(String name, EnterpriseType enterpriseType)
    {
        super(name);
        this.enterpriseType= enterpriseType;
        organizationDirectory= new OrganizationDirectory();
    }
    public enum EnterpriseType
        {
            //AdExchange("Ad Exchange"),
            Advertiser("Advertiser"),
            Publisher("Publisher"),
            Customer("Customer"),
            Supplier("Supplier");

            private String value;
            private EnterpriseType(String value)
            {
                this.value=value;
            }
            public String getValue()
            {
                return value;
            }
            @Override
            public String toString()
            {
                return value;
            }
        }        

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}
