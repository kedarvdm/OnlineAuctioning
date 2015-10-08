/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    private String name;
    
    public enum RoleType{
        /*Ad Exchange Roles*/
        SystemAdmin("System Admin Role"),
        Advertiser("Advertiser Role"),
        Publisher("Publisher Role"),
        CustomerAdmin("Customer Admin Role"),
        Supplier("Supplier"),
        
        /*Advertiser Roles*/
        AdvertiserAccountManager("Advertiser Account Manager Role"),
        AdCreator("Ad Creator Role"),
        AdInventoryManager("Ad Inventory Manager Role"),
        DSPManager("DSP Manager Role"),
        InvoiceAuditor("Invoice Auditor Role"),
        
        /*Publisher Roles*/
        PublisherAccountManager("Publisher Account Manager Role"),
        AdSpaceCreator("Ad Space Creator Role"),
        AdSpaceManager("Ad Space Manager Role"),
        InvoiceCreator("Invoice Creator Role"),
        SSPManager("SSP Manager Role"),
        
        /*Supplier Roles*/
        ProductManager("Product Manager Role"),
        SalesRepresentative("Sales Representative Role"),
        ShippingSpecialist("Shipping Specialist Role"),
        
        /*Customer Admin Roles*/
        Customer("Customer Role");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public Role(String name)
    {
        this.name=name;
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, EcoSystem business, String filePath);

    @Override
    public String toString() {
        return name;
    }
    
    
}