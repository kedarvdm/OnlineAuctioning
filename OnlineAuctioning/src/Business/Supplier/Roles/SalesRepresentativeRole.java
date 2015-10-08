/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier.Roles;

import Business.Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UserInterface.Supplier.SalesRepresentative.SalesRepresentativeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class SalesRepresentativeRole extends Role {

    public SalesRepresentativeRole()
    {
        super(RoleType.SalesRepresentative.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, String filePath) {
        return new SalesRepresentativeWorkAreaJPanel(userProcessContainer, enterprise, account, organization);
    }
}
