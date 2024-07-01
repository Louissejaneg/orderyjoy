package com.louissegarcia.orderyjoy.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "ordertbl")
public class Order {

    private @Id
    @GeneratedValue long id;
    private Long userId;
    private double totalAmount;
    private String status;

    Order(){}

    public Order(Long userId, double totalAmount, String status){
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    //setters
    public void setuserId(Long userId) {
        this.userId = userId;
    }

    public void setuserName(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setstatus(String status){
        this.status = status;
    }

    //getters

    public Long getOrderId() {
        return id;
    }

    public Long get(){
        return userId;
    }

    public double totalAmount(){
        return totalAmount;
    }


    public String getStatus() {
        return status;
    }

    


    
}
