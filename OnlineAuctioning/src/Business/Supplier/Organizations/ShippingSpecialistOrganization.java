/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier.Organizations;

import Business.Organization.Organization;

import Business.Role.Role;
import Business.Supplier.Roles.ShippingSpecialistRole;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class ShippingSpecialistOrganization extends Organization {
    
    public ShippingSpecialistOrganization()
    {
           super(SupplierOrganizationType.ShippingSpecialist.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles= new ArrayList<>();
        roles.add(new ShippingSpecialistRole());
        return roles;
    }
            
}
