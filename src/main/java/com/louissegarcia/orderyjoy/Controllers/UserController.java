package com.louissegarcia.orderyjoy.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.louissegarcia.orderyjoy.Model.UserModel;

@RestController
public class UserController {
    
    //http:localhost:8080/user
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "Garcia", "lg@gmail.com", "1234");
    }
    //Fetch multiple data
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List <UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Mario", "mario@gmail.com", "mario"));
        users.add(new UserModel(2, "Luigi", "luigi@gmail.com", "luigi"));
        users.add(new UserModel(3, "Yoshi", "yoshi@gmail.com", "yoshi"));
        return users;
        
    }
    //http://localhost:8080/user/juan
    @GetMapping("/user/{name}")
    public UserModel getUsersFromName(@PathVariable("name")String name){
        return new UserModel(1, "Garcia", "lg@gmail.com", "1234");
    }
}
