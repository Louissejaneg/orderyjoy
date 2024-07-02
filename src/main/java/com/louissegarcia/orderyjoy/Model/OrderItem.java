package com.louissegarcia.orderyjoy.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrderItem {

    private @Id
    @GeneratedValue long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private double price;

    OrderItem(){}

    public OrderItem(Long orderId, Long productId, int quantity, double price){
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    //setters
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setquantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

    //getters

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }


    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    


    
}
