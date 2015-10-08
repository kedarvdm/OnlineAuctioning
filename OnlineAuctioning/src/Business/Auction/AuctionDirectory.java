/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Auction;

import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class AuctionDirectory {

    private ArrayList<Auction> auctionList;
    
    public AuctionDirectory()
    {
        auctionList= new ArrayList<>();
    }

    public ArrayList<Auction> getAuctionList() {
        return auctionList;
    }

    public void setAuctionList(ArrayList<Auction> auctionList) {
        this.auctionList = auctionList;
    }
    
    public Auction createAndAddAuction()
    {
        Auction auction= new Auction();
        auctionList.add(auction);
        return auction;
    }
    
    
}
