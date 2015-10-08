/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.DemandSidePlatform;

import Business.Advertiser.Advertisement.Advertisement;
import Business.Customer.Customer.AgeRange;
import Business.Customer.Customer.Gender;
import Business.Customer.Customer.IncomeRange;
import Business.Customer.Customer.Occupation;

/**
 *
 * @author Sonam
 */
public class DSP {
    
    private int dspId;
    private static int count=0;
    private Advertisement advertisement;
    private AgeRange ageRange;
    private Gender gender;
    private Occupation occupation;
    private IncomeRange incomeRange;
    private double costPerClick;
    private boolean enabled;

    public DSP()
    {
        count++;
        dspId=count;
    }
    public int getDspId() {
        return dspId;
    }

    public void setDspId(int dspId) {
        this.dspId = dspId;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public double getCostPerClick() {
        return costPerClick;
    }

    public void setCostPerClick(double costPerClick) {
        this.costPerClick = costPerClick;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    @Override
    public String toString()
    {
        return String.valueOf(dspId);
    }
}
