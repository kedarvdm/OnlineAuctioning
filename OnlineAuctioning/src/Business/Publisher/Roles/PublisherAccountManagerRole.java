/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.Roles;

import Business.Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PublisherEnterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UserInterface.Publisher.AccountManagerRole.PublisherAccountManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class PublisherAccountManagerRole extends Role {

    public PublisherAccountManagerRole()
    {
        super(RoleType.PublisherAccountManager.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, String filePath) {
        return new PublisherAccountManagerWorkAreaJPanel(userProcessContainer, (PublisherEnterprise)enterprise, organization, account);
    }
    
}
