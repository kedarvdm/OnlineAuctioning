/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.WorkRequests;

import Business.Advertiser.DemandSidePlatform.DSP;
import Business.Customer.Customer;
import Business.Publisher.ServerSidePlatform.SSP;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Sonam
 */
public class PostPaymentWorkRequest extends WorkRequest {
    private Customer customer;
    private DSP dsp;
    private SSP ssp;
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DSP getDsp() {
        return dsp;
    }

    public void setDsp(DSP dsp) {
        this.dsp = dsp;
    }

    public SSP getSsp() {
        return ssp;
    }

    public void setSsp(SSP ssp) {
        this.ssp = ssp;
    }
}
