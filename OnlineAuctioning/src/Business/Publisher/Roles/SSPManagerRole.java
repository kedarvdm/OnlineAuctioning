/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.Roles;

import Business.Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UserInterface.Publisher.SSPManagerRole.SSPManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class SSPManagerRole extends Role {

    public SSPManagerRole()
    {
        super(RoleType.SSPManager.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem, String filePath) {
        return new SSPManagerWorkAreaJPanel(userProcessContainer, enterprise);
    }
    
}
