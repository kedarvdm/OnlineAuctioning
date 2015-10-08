/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Person.Person;
import Business.Role.Role;

/**
 *
 * @author raunak
 */
public class Employee extends Person{
    
    private int id;
    private static int count = 0;
    private Role role;
    public Employee() {
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getName();
    }
}
