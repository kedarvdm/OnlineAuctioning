/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer.Activity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sonam
 */
public class CustomerActivity {
    
    private static int count=0;
    private int activityId;
    private ActivityType activityType;
    private String keywords;
    private Date activityTime;
    
    public enum ActivityType{
        AddToCart("Add To Cart"),
        BuyProduct("Buy Product"),
        SearchProduct("Search Product"),
        ViewProduct("View Product"),
        AdClick("Ad Click");
        
        private String value;
        private ActivityType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getActivityTime() {
        SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        if(activityTime!=null)
        {
            return ft.format(activityTime);
        }
        else
        {
            return "";
        }
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }
    
    @Override
    public String toString()
    {
        return activityType.getValue();
    }
}
