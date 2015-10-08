/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.AdExchange.Organizations.CustomerOrganization;
import Business.Advertiser.Organizations.AdvertiserAccountManagerOrganization;
import Business.Advertiser.Organizations.AdCreatorOrganization;
import Business.Advertiser.Organizations.AdInventoryManagerOrganization;
import Business.Advertiser.Organizations.DSPManagerOrganization;
import Business.Organization.Organization.AdvertiserOrganizationType;
import Business.Organization.Organization.PublisherOrganizationType;
import Business.Organization.Organization.SupplierOrganizationType;
import Business.Organization.Organization.Type;
import Business.Publisher.Organizations.AdSpaceCreatorOrganization;
import Business.Publisher.Organizations.AdSpaceManagerOrganization;
import Business.Publisher.Organizations.PublisherAccountManagerOrganization;
import Business.Publisher.Organizations.SSPManagerOrganization;
import Business.Supplier.Organizations.ProductManagerOrganization;
import Business.Supplier.Organizations.SalesRepresentativeOrganization;
import Business.Supplier.Organizations.ShippingSpecialistOrganization;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(String type)
    {
        
        Organization organization = null;
        if (type.equals(Type.Customer.getValue())){
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }
        /*Advertiser Organizations*/
        else if (type.equals(AdvertiserOrganizationType.AdvertiserAccountManager.getValue())){
            organization = new AdvertiserAccountManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.equals(AdvertiserOrganizationType.AdCreator.getValue())){
            organization = new AdCreatorOrganization();
            organizationList.add(organization);
        }
        else if (type.equals(AdvertiserOrganizationType.AdInventoryManager.getValue())){
            organization = new AdInventoryManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.equals(AdvertiserOrganizationType.DSPManager.getValue())){
            organization = new DSPManagerOrganization();
            organizationList.add(organization);
        }
        /*Publisher Organizations*/
        else if (type.equals(PublisherOrganizationType.PublisherAccountManager.getValue())){
            organization = new PublisherAccountManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.equals(PublisherOrganizationType.AdSpaceManager.getValue())){
            organization = new AdSpaceManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.equals(PublisherOrganizationType.AdSpaceCreator.getValue())){
            organization = new AdSpaceCreatorOrganization();
            organizationList.add(organization);
        }
        else if (type.equals(PublisherOrganizationType.SSPManager.getValue())){
            organization = new SSPManagerOrganization();
            organizationList.add(organization);
        }
        /*Supplier Organizations*/
        else if (type.equals(SupplierOrganizationType.ProductManager.getValue())){
            organization = new ProductManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.equals(SupplierOrganizationType.SalesRepresentative.getValue())){
            organization = new SalesRepresentativeOrganization();
            organizationList.add(organization);
        }
        else if (type.equals(SupplierOrganizationType.ShippingSpecialist.getValue())){
            organization = new ShippingSpecialistOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    /*Ad Exchange Organizations*/
//    public Organization createOrganization(Type type){
//        Organization organization = null;
//        if (type.getValue().equals(Type.Advertiser.getValue())){
//            organization = new AdvertiserOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(Type.Customer.getValue())){
//            organization = new CustomerOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(Type.Publisher.getValue())){
//            organization = new PublisherOrganization();
//            organizationList.add(organization);
//        }
//        return organization;
//    }
    
//    /*Advertiser Organizations*/
//    public Organization createOrganization(AdvertiserOrganizationType type){
//        Organization organization = null;
//        if (type.getValue().equals(AdvertiserOrganizationType.AdvertiserAccountManager.getValue())){
//            organization = new AdvertiserAccountManagerOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(AdvertiserOrganizationType.AdCreator.getValue())){
//            organization = new AdCreatorOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(AdvertiserOrganizationType.AdInventoryManager.getValue())){
//            organization = new AdInventoryManagerOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(AdvertiserOrganizationType.DSPManager.getValue())){
//            organization = new DSPManagerOrganization();
//            organizationList.add(organization);
//        }
//        return organization;
//    }
    
    /*Publisher Organizations*/
//    public Organization createOrganization(PublisherOrganizationType type){
//        Organization organization = null;
//        if (type.getValue().equals(PublisherOrganizationType.PublisherAccountManager.getValue())){
//            organization = new PublisherAccountManagerOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(PublisherOrganizationType.AdSpaceManager.getValue())){
//            organization = new AdSpaceManagerOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(PublisherOrganizationType.AdSpaceCreator.getValue())){
//            organization = new AdSpaceCreatorOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(PublisherOrganizationType.SSPManager.getValue())){
//            organization = new SSPManagerOrganization();
//            organizationList.add(organization);
//        }
//        return organization;
//    }
    
//    public Organization createOrganization(Organization.SupplierOrganizationType type){
//        Organization organization = null;
//        if (type.getValue().equals(SupplierOrganizationType.ProductManager.getValue())){
//            organization = new ProductManagerOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(SupplierOrganizationType.SalesRepresentative.getValue())){
//            organization = new SalesRepresentativeOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(SupplierOrganizationType.ShippingSpecialist.getValue())){
//            organization = new ShippingSpecialistOrganization();
//            organizationList.add(organization);
//        }
//        return organization;
//    }
}