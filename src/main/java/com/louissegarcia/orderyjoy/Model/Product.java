package com.louissegarcia.orderyjoy.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    private @Id
    @GeneratedValue long id;
    private String productname;
    private String decription;
    private double price;
    private String description;

    Product(){}

    public Product(String productname, String description, double price) {
        this.productname = productname;
        this.description = description;
        this.price = price;
    }

    //setters
    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //getters
    public long getId() {
        return id;
    }

    public String getProductname() {
        return productname;
    }

    public String getDecription() {
        return decription;
    }

    public double getPrice() {
        return price;
    }

    


    
}
