/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private boolean hasProcessed=false;
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestDate() {
        SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        if(requestDate!=null)
        {
            return ft.format(requestDate);
        }
        else
        {
            return "";
        }
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getResolveDate() {
        SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        if(resolveDate!=null)
        {
            return ft.format(resolveDate);
        }
        else
        {
            return "";
        }
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public boolean isHasProcessed() {
        return hasProcessed;
    }

    public void setHasProcessed(boolean hasProcessed) {
        this.hasProcessed = hasProcessed;
    }
    
    @Override
    public String toString()
    {
        return message;
    }
}
