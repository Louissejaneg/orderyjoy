package com.louissegarcia.orderyjoy.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.louissegarcia.orderyjoy.Model.Order;
import com.louissegarcia.orderyjoy.NotFoundException.OrderNotFoundException;
import com.louissegarcia.orderyjoy.Repository.OrderRepository;

@RestController
public class OrderController {

    OrderRepository repo;


    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    //http://127.0.0.1:8080/Order
    //Get all products
    @GetMapping("/Order")
    public List<Order> getOrder(){
        return repo.findAll();
    }

    //http://127.0.0.1:8080/Order/52
    @GetMapping("/Order/{id}")
     public Order getOrder(@PathVariable Long id){
         return repo.findById(id)
         .orElseThrow(()-> new OrderNotFoundException(id));
     }

//http:127.0.0.1:8080/Order/new
    @PostMapping("/Order/new")
    public String addOrder(@RequestBody Order newOrder){
        repo.save(newOrder);
        return "A new Order is added Yey!";

    }

        //Delete Endpoints
    //http://127.0.0.1:8080/Order/delete/1
    @DeleteMapping("/Order/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        repo.deleteById(id);
        return "A Order is deleted";
    }

}
