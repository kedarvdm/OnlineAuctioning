/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Auction;

import Business.Advertiser.Advertisement.Advertisement;
import Business.Advertiser.DemandSidePlatform.DSP;
import Business.Advertiser.DemandSidePlatform.DSPDirectory;
import Business.Customer.Customer;
import Business.Enterprise.AdvertiserEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Publisher.ServerSidePlatform.SSP;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sonam
 */
public class Auction {
    private static int count=0;
    private int auctionID;
    private SSP initiatingSSP;
    private DSPDirectory participatingDSPs;
    private DSP winningDSP;
    private Date auctionDate;
    private Network network;
    
    public Auction()
    {
        count++;
        auctionID=count;
        participatingDSPs= new DSPDirectory();
        auctionDate= new Date();
    }

    public int getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

    public SSP getInitiatingSSP() {
        return initiatingSSP;
    }

    public void setInitiatingSSP(SSP initiatingSSP) {
        this.initiatingSSP = initiatingSSP;
    }

    public DSPDirectory getParticipatingDSPs() {
        return participatingDSPs;
    }

    public void setParticipatingDSPs(DSPDirectory participatingDSPs) {
        this.participatingDSPs = participatingDSPs;
    }

    public DSP getWinningDSP() {
        return winningDSP;
    }

    public void setWinningDSP(DSP winningDSP) {
        this.winningDSP = winningDSP;
    }

    public String getAuctionDate() {
        SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        if(auctionDate!=null)
        {
            return ft.format(auctionDate);
        }
        else
        {
            return "";
        }
    }

    public void setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
    
    public DSP getCalualteAuctionResult(SSP ssp,Customer customer, Network network, ArrayList<Advertisement> ignoreList,StringBuilder browsingHistory)
    {
        DSP dsp=null;
        System.out.println("Checking Advertiser DSPs");
        for(Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList())
        {
            if(enterprise instanceof AdvertiserEnterprise)
            {
                System.out.println("Getting DSPs from "+enterprise.getName());
                dsp=((AdvertiserEnterprise)enterprise).getDspDirectory().getDSPForAuction(customer, ssp,ignoreList,browsingHistory);
                if(dsp!=null)
                {
                    participatingDSPs.addDSP(dsp);
                }
            }
        }
        System.out.println("DSP selection completed");
        
        double currentPrice=0;
        double previousPrice=0;
        DSP bestDSP=null;
        
        if(!participatingDSPs.getDspList().isEmpty())
        {
            System.out.println("No DSP found");
        }
        
        for(DSP d: participatingDSPs.getDspList())
        {
            currentPrice=d.getCostPerClick();
            if(currentPrice>previousPrice)
            {
                bestDSP=d;
                previousPrice=currentPrice;
            }
        }
        
        if(bestDSP!=null)
        {
            System.out.println("Selected best DSP among all Advertisements");
        }
        
        return bestDSP;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(auctionID);
    }
}
