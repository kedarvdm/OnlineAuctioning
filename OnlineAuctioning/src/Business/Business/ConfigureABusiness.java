/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Business;

import Business.AdExchange.Roles.SystemAdminRole;
import Business.Employee.Employee;
import Business.UserAccount.UserAccount;

/**
 *
 * @author raunak
 */
public class ConfigureABusiness {
    
    public static EcoSystem configure(){
        
        EcoSystem system= EcoSystem.getInstance();
        //Create a network 
        //Create a enterprise
        //Create a organizations
        
        Employee employee= system.getPersonDirectory().createAndAddEmployee();
        employee.setName("Kedar Deshmukh");
        UserAccount ua= system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return system;
    }
    
}
