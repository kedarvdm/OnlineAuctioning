/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.Organizations;

import Business.Advertiser.Roles.AdInventoryManagerRole;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class AdInventoryManagerOrganization extends Organization{
    
    public AdInventoryManagerOrganization()
    {
        super(AdvertiserOrganizationType.AdInventoryManager.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdInventoryManagerRole());
        return roles;
    }
    
}
