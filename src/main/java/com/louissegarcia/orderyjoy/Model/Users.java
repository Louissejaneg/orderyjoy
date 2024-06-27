package com.louissegarcia.orderyjoy.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
    private @Id
    @GeneratedValue Long id;
    private String username;
    private String address;
    private int age;

    Users(){}

    public Users(String username, String address, int age) {
        this.username = username;
        this.address = address;
        this.age = age;
    }

    //setters
    public void setusername(String username) {
        this.username = username;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setage(int age) {
        this.age = age;
    }

    //getters
    public long getId() {
        return id;
    }

    public String getusername() {
        return username;
    }

    public String getaddress() {
        return address;
    }

    public int getage() {
        return age;
    }

}
