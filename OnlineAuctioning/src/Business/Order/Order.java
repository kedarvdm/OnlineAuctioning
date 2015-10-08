/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Order;

import Business.Product.Product;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Guest
 */
public class Order {
    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private static int count=0;
    private int customerID;
    private Date orderDate;
    private int orderTotal=0;
    private String status;
    private Date statusBy;
   
    public Order()
    {
        orderDate= new Date();
        orderItemList= new ArrayList<OrderItem>();
        count++;
        orderNumber=count;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }
    
    public void removeOrderItem(OrderItem o)
    {
        int avail=o.getProduct().getAvailibility();
        int newAvail= avail+o.getQuantity();
        o.getProduct().setAvailibility(newAvail);
        orderItemList.remove(o);
        
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        if(orderDate!=null)
        {
            return ft.format(orderDate);
        }
        else
        {
            return "";
        }
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusBy() {
        SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
        if(statusBy!=null)
        {
            return ft.format(statusBy);
        }
        else
        {
            return "";
        }
    }

    public void setStatusBy(Date statusBy) {
        this.statusBy = statusBy;
    }
    
    public OrderItem addOrderItem(Product p, int quantity)
    {
        OrderItem o= new OrderItem();
        o.setProduct(p);
        o.setQuantity(quantity);
        orderItemList.add(o);
        return o;
    }
    
    @Override
    public String toString()
    {
        return "Order Number: "+String.valueOf(orderNumber);
    }
}
