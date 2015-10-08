/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.Roles;

import Business.Business.EcoSystem;
import Business.Enterprise.AdvertiserEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UserInterface.Advertiser.AccountManagerRole.AdvertiserAccountManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sonam
 */
public class AdvertiserAccountsManagerRole extends Role {
    
    public AdvertiserAccountsManagerRole()
    {
        super(RoleType.AdvertiserAccountManager.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, String filePath) {
        return new AdvertiserAccountManagerWorkAreaJPanel(userProcessContainer, (AdvertiserEnterprise)enterprise, organization, account);
    }
}
