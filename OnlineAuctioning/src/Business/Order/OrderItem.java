/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Order;

import Business.Product.Product;

/**
 *
 * @author Guest
 */
public class OrderItem {
    private Product product;
    private int quantity;
    private int salesPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.salesPrice= this.quantity*this.product.getPrice();
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }
    
    @Override
    public String toString()
    {
        return  product.getProdName();
    }
}
