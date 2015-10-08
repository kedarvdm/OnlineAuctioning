/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Product;

/**
 *
 * @author Rushabh
 */
public class Product {
    private static int count = 0;
    private String prodName;
    private int price;
    private int modelNumber;
    private int availibility;
    private int soldCount;

    public Product() {
        count++;
        modelNumber = count;
    }
    
    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getModelNumber() {
        return modelNumber;
    }
    
    public int getAvailibility() {
        return availibility;
    }

    public void setAvailibility(int availibility) {
        this.availibility = availibility;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }
    
    @Override
    public String toString() {
        return prodName;
    }
    
}
