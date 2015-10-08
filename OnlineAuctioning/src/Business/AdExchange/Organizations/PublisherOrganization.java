/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AdExchange.Organizations;

import Business.AdExchange.Roles.PublisherRole;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class PublisherOrganization extends Organization {

    public PublisherOrganization()
    {
        super(Type.Publisher.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PublisherRole());
        return roles;
    }
    
}
