/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.Advertisement;

import Business.Enterprise.Enterprise;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sonam
 */
public class Advertisement {

    private static int count = 0;
    private int advertisementID;
    private Enterprise enterprice;
    private int clickCount=0;
    private String title;
    private int width;
    private int height;
    private String location;
    private Date dateCreated;
    private boolean ready;
    private boolean enabled;
    private String notes;
    private String adWords;

    public Advertisement() {
        count++;
        advertisementID = count;
    }

    public int getAdvertisementID() {
        return advertisementID;
    }

    public void setAdvertisementID(int advertisementID) {
        this.advertisementID = advertisementID;
    }

    public Enterprise getEnterprice() {
        return enterprice;
    }

    public void setEnterprice(Enterprise enterprice) {
        this.enterprice = enterprice;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateCreated() {
        SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        if(dateCreated!=null)
        {
            return ft.format(dateCreated);
        }
        else
        {
            return "";
        }
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAdWords() {
        return adWords;
    }

    public void setAdWords(String adWords) {
        this.adWords = adWords;
    }

    @Override
    public String toString() {
        return title;
    }
}
