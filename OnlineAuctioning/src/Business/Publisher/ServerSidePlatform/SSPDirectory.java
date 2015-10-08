/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher.ServerSidePlatform;

import Business.Customer.Customer;
import Business.Publisher.AdSpace.AdSpace;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class SSPDirectory {

    private ArrayList<SSP> sspList;
    
    public SSPDirectory()
    {
        sspList= new ArrayList<>();
    }

    public ArrayList<SSP> getSspList() {
        return sspList;
    }

    public void setSspList(ArrayList<SSP> sspList) {
        this.sspList = sspList;
    }
    
    public SSP createAndAddSSP()
    {
        SSP ssp= new SSP();
        sspList.add(ssp);
        return ssp;
    }

    public void removeSSP(SSP ssp)
    {
        sspList.remove(ssp);
    }
    
    public SSP getSSPForAuction(Customer customer, AdSpace adSpace)
    {
        ArrayList<SSP> selectedSSPs=new ArrayList<>();
        
        //Get SSPs
        
        for(SSP ssp:sspList)
        {
            if((ssp.getAdSpace()==adSpace)                                                              //Get SSP for the AdSpace only
            &&(customer.getGender()==ssp.getGender() || (ssp.getGender()==Customer.Gender.Any))         //Check gender conditions
            &&(ssp.isEnabled())                                                                         //Check if DSP is enabled
            &&(ssp.getAdSpace().isEnabled()))                                                           //Check if AdSpace is enabled
            {
                selectedSSPs.add(ssp);
            }
        }
        if(!selectedSSPs.isEmpty())
        {
            System.out.println("Selected SSP's based on customer profile");
        }
        else
        {
            System.out.println("No SSP found");
        }
        
        //Get max base price for scoring
        double currentBasePrice=0;
        double previousBasePrice=0;
        double maxBasePrice=0;
        for(SSP ssp:selectedSSPs)
        {
            currentBasePrice=ssp.getBasePrice();
            
            if(currentBasePrice>previousBasePrice)
            {
                maxBasePrice=currentBasePrice;
                previousBasePrice=currentBasePrice;
            }
        }
        if(maxBasePrice>0)
        {
            System.out.println("SSP with max base price found");
        }
        
        double hitScore=100;
        
        //calculate score for each selectedSSPS
        ArrayList<SSPWithScore> sspWithScoreList=new ArrayList<>();
        for(SSP ssp:selectedSSPs)
        {
            double score=0;
            SSPWithScore sSPWithScore= new SSPWithScore();
            
            if((ssp.getAgeRange()==customer.getAgeRange())|| (ssp.getAgeRange()==Customer.AgeRange.Any))
            {
                score=score+hitScore;
            }
            if((ssp.getOccupation()==customer.getOccupation())|| (ssp.getOccupation()==Customer.Occupation.Any))
            {
                score=score+hitScore;
            }
            if((ssp.getIncomeRange()==customer.getIncomeRange())|| (ssp.getIncomeRange()==Customer.IncomeRange.Any))
            {
                score=score+hitScore;
            }
            
            //Points for Base Price will be assigned in proportion to the Max Base Price.
            score= score+((ssp.getBasePrice()/maxBasePrice)*100);
            sSPWithScore.setSsp(ssp);
            sSPWithScore.setSspScore(score);
            sspWithScoreList.add(sSPWithScore);
        }
        if(!sspWithScoreList.isEmpty())
        {
            System.out.println("SSP scoring complete");
        }
        //Sort and get best SSP
        SSP bestSSP=null;
        double currentScore=0;
        double previousSore=0;
        double currentPrice=0;
        double previousPrice=0;
        
        for(SSPWithScore s: sspWithScoreList)
        {
            currentScore=s.getSspScore();
            currentPrice=s.getSsp().getBasePrice();
            if(currentScore>previousSore ||(currentScore==previousSore && currentPrice>previousPrice))
            {
                bestSSP=s.getSsp();
                previousSore=currentScore;
                previousPrice=currentBasePrice;
            }
        }
        if(bestSSP!=null)
        {
            System.out.println("Best SSP selected");
        }
        
        //Return the Best SSP
        return bestSSP;
    }
}
