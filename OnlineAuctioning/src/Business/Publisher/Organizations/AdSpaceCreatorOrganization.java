/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.Organizations;

import Business.Organization.Organization;
import Business.Publisher.Roles.AdSpaceCreatorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class AdSpaceCreatorOrganization extends Organization {
    
    public AdSpaceCreatorOrganization()
    {
        super(PublisherOrganizationType.AdSpaceCreator.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdSpaceCreatorRole());
        return roles;
    }
}
