/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;


import Business.Advertiser.Advertiser;
import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Publisher.Publisher;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class PersonDirectory {
    private ArrayList<Person> personDirectory;
    
    public PersonDirectory()
    {
        personDirectory= new ArrayList<>();
    }

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(ArrayList<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    public Employee createAndAddEmployee()
    {
        Employee p= new Employee();
        personDirectory.add(p);
        return p;
    }
    
    public Customer createAndAddCustomer()
    {
        Customer p= new Customer();
        personDirectory.add(p);
        return p;
    }
     
    public Publisher createAndAddPublisher()
    {
        Publisher p= new Publisher();
        personDirectory.add(p);
        return p;
    }
    
    public Advertiser createAndAddAdvertiser()
    {
        Advertiser p= new Advertiser();
        personDirectory.add(p);
        return p;
    }
    
   
    
    public void removePerson(Person person)
    {
        personDirectory.remove(person);
    }
}
