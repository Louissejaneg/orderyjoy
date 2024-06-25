package com.louissegarcia.orderyjoy.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.louissegarcia.orderyjoy.Model.Product;
import com.louissegarcia.orderyjoy.Repository.ProductRepository;

@RestController
public class ProductController {

    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    //Get all products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return repo.findAll();
    }

//     public Product getProduct(long id){
//         return repo.findById(id);
//     }

//http:127.0.0.1:8080/product/new
    @PostMapping("/product/new")
    public String addProducts(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added Yey!";

    }

}
