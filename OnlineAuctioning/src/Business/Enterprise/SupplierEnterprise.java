/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Product.ProductCatalog;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class SupplierEnterprise extends Enterprise{
    private ProductCatalog productCatalog;
    public SupplierEnterprise(String name, EnterpriseType type)
    {
        super(name,type);
        productCatalog = new ProductCatalog();
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
