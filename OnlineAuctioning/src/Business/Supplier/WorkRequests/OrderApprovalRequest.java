/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier.WorkRequests;

import Business.Order.Order;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Sonam
 */
public class OrderApprovalRequest extends WorkRequest {
    
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
