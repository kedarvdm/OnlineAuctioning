/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory()
    {
        enterpriseList= new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType enterpriseType)
    {
        Enterprise enterprise=null;
        if(enterpriseType==Enterprise.EnterpriseType.Advertiser)
        {
            enterprise= new AdvertiserEnterprise(name, enterpriseType);
            enterpriseList.add(enterprise);
        } else if(enterpriseType==Enterprise.EnterpriseType.Publisher)
        {
            enterprise= new PublisherEnterprise(name, enterpriseType);
            enterpriseList.add(enterprise);
        }
        else if(enterpriseType==Enterprise.EnterpriseType.Customer)
        {
            enterprise= new CustomerEnterprise(name, enterpriseType);
            enterpriseList.add(enterprise);
        }
        else if(enterpriseType==Enterprise.EnterpriseType.Supplier)
        {
            enterprise= new SupplierEnterprise(name, enterpriseType);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
