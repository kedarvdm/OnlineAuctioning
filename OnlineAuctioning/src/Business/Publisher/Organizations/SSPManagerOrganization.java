/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.Organizations;

import Business.Organization.Organization;
import Business.Publisher.Roles.SSPManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class SSPManagerOrganization extends Organization{

    public SSPManagerOrganization()
    {
        super(PublisherOrganizationType.SSPManager.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SSPManagerRole());
        return roles;
    }    
}
