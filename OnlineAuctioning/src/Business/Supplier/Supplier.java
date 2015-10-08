/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Supplier;

import Business.Product.ProductCatalog;
import Business.Person.Person;

/**
 *
 * @author Rushabh
 */
public class Supplier extends Person {
    private static int count = 0;
    private int supplierID;
    
    
    public Supplier() {
        count++;
        supplierID=count;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
}
