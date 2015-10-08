/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.ServerSidePlatform;

import Business.Customer.Customer.AgeRange;
import Business.Customer.Customer.Gender;
import Business.Customer.Customer.IncomeRange;
import Business.Customer.Customer.Occupation;
import Business.Publisher.AdSpace.AdSpace;

/**
 *
 * @author Sonam
 */
public class SSP {
    
    private int sspId;
    private static int count=0;
    private AdSpace adSpace;
    private AgeRange ageRange;
    private Gender gender;
    private Occupation occupation;
    private IncomeRange incomeRange;
    private double basePrice;
    private boolean enabled;

    public SSP()
    {
        count++;
        sspId=count;
    }

    public int getSspId() {
        return sspId;
    }

    public void setSspId(int sspId) {
        this.sspId = sspId;
    }

    public AdSpace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(AdSpace adSpace) {
        this.adSpace = adSpace;
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

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
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
        return String.valueOf(sspId);
    }
}
