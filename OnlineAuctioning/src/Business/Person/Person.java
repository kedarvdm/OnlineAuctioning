/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author Sonam
 */
public class Person {
    private static int count=0;
    private int personID;
    private String name;
    
    public Person()
    {
        count++;
        personID=count;
    }

    public static int getCount() {
        return count;
    }

    public int getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
