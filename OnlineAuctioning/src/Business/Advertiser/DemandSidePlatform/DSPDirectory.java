/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.DemandSidePlatform;

import Business.Advertiser.Advertisement.Advertisement;
import Business.Customer.Customer;
import Business.Publisher.ServerSidePlatform.SSP;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class DSPDirectory {

    private ArrayList<DSP> dspList;
    
    public DSPDirectory()
    {
        dspList= new ArrayList<>();
    }

    public ArrayList<DSP> getDspList() {
        return dspList;
    }

    public void setDspList(ArrayList<DSP> dspList) {
        this.dspList = dspList;
    }
    
    public DSP createAndAddDSP()
    {
        DSP dsp= new DSP();
        dspList.add(dsp);
        return dsp;
    }

    public void removeDSP(DSP dsp)
    {
        dspList.remove(dsp);
    }
    
    public void addDSP(DSP dsp)
    {
        dspList.add(dsp);
    }
    
    public DSP getDSPForAuction(Customer customer,SSP ssp,ArrayList<Advertisement> ignoreList,StringBuilder browsingHistory)
    {
        ArrayList<DSP> selectedDSPs=new ArrayList<>();
        ArrayList<DSP> ignoredDSPs= new ArrayList<>();
        
        //Get DSPs
        
        for(DSP dsp:dspList)
        {
            if(((customer.getGender()==dsp.getGender()) || (dsp.getGender()==Customer.Gender.Any))      //Check gender requirements
            &&(dsp.getCostPerClick()>=ssp.getBasePrice())                                                //Check if above Base price
            &&(dsp.getAdvertisement().getHeight()<=ssp.getAdSpace().getHeight())                        //Check if fits in Height 
            &&(dsp.getAdvertisement().getWidth()<=ssp.getAdSpace().getWidth())                          //Check if fits in Width
            &&(dsp.isEnabled())                                                                         //Check if DSP is enabled
            &&(dsp.getAdvertisement().isEnabled()))                                                     //Check if Advertisement is enabled
            {
                selectedDSPs.add(dsp);
            }
        }
        System.out.println("DSPs selected based on Customer Profile");
        //Remove already shown advertises for this customer
        for(Advertisement a:ignoreList)
        {
            for(DSP dsp:selectedDSPs)
            {
                if(dsp.getAdvertisement()==a)
                {
                    ignoredDSPs.add(dsp);
                }
            }
        }
        
        //Remove ignored DSP's
        selectedDSPs.removeAll(ignoredDSPs);
        System.out.println("Removed ignored DSP's");
        
        int hitScore=100;
        //calculate score for each selectedDSPS
        ArrayList<DSPWithScore> dspWithScoreList=new ArrayList<>();
        for(DSP dsp:selectedDSPs)
        {
            System.out.println("Scoring DSP's based on customer profile");
            double score=0;
            DSPWithScore dSPWithScore= new DSPWithScore();
            
            if((dsp.getAgeRange()==customer.getAgeRange())|| (dsp.getAgeRange()==Customer.AgeRange.Any))
            {
                score=score+hitScore;
            }
            if((dsp.getOccupation()==customer.getOccupation())|| (dsp.getOccupation()==Customer.Occupation.Any))
            {
                score=score+hitScore;
            }
            if((dsp.getIncomeRange()==customer.getIncomeRange())|| (dsp.getIncomeRange()==Customer.IncomeRange.Any))
            {
                score=score+hitScore;
            }
            
            //Check if any of adWords is present in Browsing History of customer.
            //If any one word matches, the product is relevant and score will be updated.
            System.out.println("Checking customers Browsing history");
            String[] strArray=dsp.getAdvertisement().getAdWords().split(",");
            
            for(String str:strArray)
            {
                if(browsingHistory.toString().contains(str.toLowerCase()))
                {
                    score=score+hitScore;
                    break;
                }
            }
            dSPWithScore.setDsp(dsp);
            dSPWithScore.setDspScore(score);
            dspWithScoreList.add(dSPWithScore);
        }
        
        System.out.println("Scoring completed");
        //Sort and get best DSP
        DSP bestDSP=null;
        double currentScore=0;
        double previousSore=0;
        double currentPrice=0;
        double previousPrice=0;
        
        for(DSPWithScore d: dspWithScoreList)
        {
            currentScore=d.getDspScore();
            currentPrice= d.getDsp().getCostPerClick();
            if(currentScore>previousSore
            ||(currentScore==previousSore && currentPrice>previousPrice))       //If score is same then max cost will win
            {
                bestDSP=d.getDsp();
                previousSore=currentScore;
                previousPrice=currentPrice;
            }
        }
        System.out.println("Best DSP selected");
        
        //Return the Best SSP
        return bestDSP;
    }
}
