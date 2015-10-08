/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.WorkRequests;

import Business.Publisher.AdSpace.AdSpace;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Sonam
 */
public class RequestPaymentWorkRequest extends WorkRequest{
    private String adName;
    private AdSpace adSpace;
    private double amount;
    private boolean paid;

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public AdSpace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(AdSpace adSpace) {
        this.adSpace = adSpace;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
