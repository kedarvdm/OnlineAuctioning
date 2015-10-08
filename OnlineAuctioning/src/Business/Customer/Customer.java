/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;


import Business.Customer.Activity.CustomerActivity;
import Business.Customer.Activity.CustomerActivityDirectory;
import Business.Order.Order;
import Business.Person.Person;

/**
 *
 * @author Sonam
 */
public class Customer extends Person {
    private static int count = 0;
    private int customerID;
    private String address1;
    private String city;
    private String state;
    private String country;
    private String zip;
    private Gender gender;
    private AgeRange ageRange;
    private Occupation occupation;
    private IncomeRange incomeRange;
    private String customerEmail;
    private String phoneNumber;
    private Order order;
    private CustomerActivityDirectory activityList;
    
    public enum Occupation{
        Any("Any"),
        Agriculture("Agriculture"),
        ArtsDesign("Art & Design"),
        Business("Business"),
        Computer("Computer"),
        Education("Education"),
        Government("Government"),
        Private("Private"),
        Healthcare("Healthcare"),
        Student("Student");
        
        private String value;
        private Occupation(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum Gender{
        Any("Any"),
        Male("Male"),
        Female("Female");
        
        private String value;
        private Gender(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    
    public enum IncomeRange{
        Any("Any"),
        ZeroTo25("$0 - $25,000"),
        TwentyFiveTo50("$25,000 - $50,000"),
        FiftyTo75("$50,000 - $75,000"),
        SeventyFiveTo100("$75,000 - $100,000"),
        HundreadPlus("$100,000 +");
        
        private String value;
        private IncomeRange(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum AgeRange{
        Any("Any"),
        FifteenTo25("15-25"),
        TwentyFiveTo35("25-35"),
        ThirtyFiveto45("35-45"),
        FourtyFiveTo55("45-55"),
        FiftyFiveTo65("55-65"),
        SixtyFivePlus("65+");
        
        private String value;
        private AgeRange(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Customer()
    {
        count++;
        customerID=count;
        order=new Order();
        order.setCustomerID(customerID);
        activityList= new CustomerActivityDirectory();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public IncomeRange getIncomeRange() {
        return incomeRange;
    }

    public void setIncomeRange(IncomeRange incomeRange) {
        this.incomeRange = incomeRange;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order createNewOrder()
    {
        //Deleting old order
        //Creating new order
        //assigning new order
        order=new Order();
        order.setCustomerID(customerID);
        return order;
    }

    public CustomerActivityDirectory getActivityList() {
        return activityList;
    }

    public void setActivityList(CustomerActivityDirectory activityList) {
        this.activityList = activityList;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
}
