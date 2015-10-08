/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer.Activity;

import Business.Customer.Activity.CustomerActivity.ActivityType;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class CustomerActivityDirectory {
    private ArrayList<CustomerActivity> customerActivityList;
    
    public CustomerActivityDirectory()
    {
        customerActivityList= new ArrayList<>();
    }

    public ArrayList<CustomerActivity> getCustomerActivityList() {
        return customerActivityList;
    }

    public void setCustomerActivityList(ArrayList<CustomerActivity> customerActivityList) {
        this.customerActivityList = customerActivityList;
    }
    
    public CustomerActivity logCustomerActivity()
    {
        CustomerActivity activity= new CustomerActivity();
        customerActivityList.add(activity);
        return activity;
    }
    
    public Boolean searchDuplicateActivity(ActivityType type, String keywords, String timeStamp)
    {
        for(CustomerActivity activity:customerActivityList)
        {
            if(activity.getActivityType()==type 
                && activity.getKeywords().trim().toLowerCase().equals(keywords.trim().toLowerCase())
                && activity.getActivityTime().equals(timeStamp))
            {
                return true;
            }
        }
        return false;
    }
    
    public void removeActivity(CustomerActivity activity)
    {
        customerActivityList.remove(activity);
    }
}
