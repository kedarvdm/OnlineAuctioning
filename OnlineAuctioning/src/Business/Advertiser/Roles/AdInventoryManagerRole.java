/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.Roles;


import Business.Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UserInterface.Advertiser.AdInventoryManagerRole.AdInventoryManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class AdInventoryManagerRole extends Role{

    public AdInventoryManagerRole()
    {
        super(RoleType.AdInventoryManager.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, String filePath) {
        return new AdInventoryManagerWorkAreaJPanel(userProcessContainer, enterprise, account, filePath);
    }
    
}
