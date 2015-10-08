/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.AdSpace;

import Business.Enterprise.Enterprise;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sonam
 */
public class AdSpace {
    private static int count=0;
    private int adSpaceID;
    private Enterprise enterprice;
    private String title;
    private int x;
    private int y;
    private int width;
    private int height;
    private Date dateCreated;
    private boolean ready;
    private boolean enabled;
    private String notes;
    
    public AdSpace()
    {
        count++;
        adSpaceID=count;
    }

    public int getAdSpaceID() {
        return adSpaceID;
    }

    public void setAdSpaceID(int adSpaceID) {
        this.adSpaceID = adSpaceID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public void setDateCreated(Date dateDreated) {
        this.dateCreated = dateDreated;
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

    public Enterprise getEnterprice() {
        return enterprice;
    }

    public void setEnterprice(Enterprise enterprice) {
        this.enterprice = enterprice;
    }

    @Override
    public String toString()
    {
        return title;
    }
    
}
