/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.Organizations;

import Business.Organization.Organization;
import Business.Publisher.Roles.AdSpaceManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class AdSpaceManagerOrganization extends Organization {

    public AdSpaceManagerOrganization()
    {
        super(PublisherOrganizationType.AdSpaceManager.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdSpaceManagerRole());
        return roles;
    }
}
