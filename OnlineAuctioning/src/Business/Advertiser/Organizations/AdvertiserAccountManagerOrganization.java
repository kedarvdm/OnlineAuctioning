/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.Organizations;

import Business.Advertiser.Roles.AdvertiserAccountsManagerRole;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class AdvertiserAccountManagerOrganization extends Organization {

    public AdvertiserAccountManagerOrganization()
    {
        super(AdvertiserOrganizationType.AdvertiserAccountManager.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdvertiserAccountsManagerRole());
        return roles;
    }
}
