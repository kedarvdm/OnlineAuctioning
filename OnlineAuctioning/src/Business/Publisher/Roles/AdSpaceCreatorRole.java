/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.Roles;

import Business.Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import UserInterface.Publisher.AdSpaceCreatorRole.AdSpaceCreatorWorkAreaJPanel;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class AdSpaceCreatorRole extends Role {
    
    public AdSpaceCreatorRole()
    {
        super(RoleType.AdSpaceCreator.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, String filePath) {
        return new AdSpaceCreatorWorkAreaJPanel(userProcessContainer, organization, account);
    }
    
}
