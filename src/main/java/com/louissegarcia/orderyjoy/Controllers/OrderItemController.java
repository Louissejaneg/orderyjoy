package com.louissegarcia.orderyjoy.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.louissegarcia.orderyjoy.Model.OrderItem;
import com.louissegarcia.orderyjoy.NotFoundException.OrderItemNotFoundException;
import com.louissegarcia.orderyjoy.Repository.OrderItemRepository;

@RestController
public class OrderItemController {

    OrderItemRepository repo;


    public OrderItemController(OrderItemRepository repo) {
        this.repo = repo;
    }

    //http://127.0.0.1/orderItem
    //Get all orderItem
    @GetMapping("/orderItem")
    public List<OrderItem> getOrderItem(){
        return repo.findAll();
    }

    //http://127.0.0.1:8080/orderItem/52
    @GetMapping("/orderItem/{id}")
     public OrderItem getOrderItem(@PathVariable Long id){
         return repo.findById(id)
.orElseThrow(()-> new OrderItemNotFoundException(id));
     }

//http:127.0.0.1:8080/orderItem/new
    @PostMapping("/orderItem/new")
    public String addorderItem(@RequestBody OrderItem newOrderItem){
        repo.save(newOrderItem);
        return "A new order item is added Yey!";

    }

       //Delete Endpoints
    //http://127.0.0.1:8080/orderItem/delete/1
    @DeleteMapping("/orderItem/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id){
        repo.deleteById(id);
        return "A order item is deleted";
    }

}
