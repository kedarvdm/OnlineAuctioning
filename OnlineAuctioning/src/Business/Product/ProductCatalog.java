/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Product;

import java.util.ArrayList;

/**
 *
 * @author Rushabh
 */
public class ProductCatalog {
    
    private ArrayList<Product> productCatalog;
    
    public ProductCatalog() {
        productCatalog = new ArrayList<Product>();
    }

    public ArrayList<Product> getProductCatalog() {
        return productCatalog;
    }
    
    public Product addProduct() {
        Product p = new Product();
        productCatalog.add(p);
        return p;
    }
    
    public void removeProduct(Product p) {
        productCatalog.remove(p);
    }
    
    public Product searchProduct(int id) {
        for(Product p : productCatalog) {
            if(p.getModelNumber() == id) {
                return p;
            }
        }
        return null;
    }
    
    public Product searchProduct(String key) {
        for(Product p : productCatalog) {
            if(p.getProdName().toLowerCase().equals(key.toLowerCase()) ) {
                return p;
            }
        }
        return null;
    }
}
