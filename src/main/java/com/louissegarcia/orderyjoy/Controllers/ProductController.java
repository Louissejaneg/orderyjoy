package com.louissegarcia.orderyjoy.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louissegarcia.orderyjoy.Model.Product;
import com.louissegarcia.orderyjoy.NotFoundException.ProductNotFoundException;
import com.louissegarcia.orderyjoy.Repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    ProductRepository repo;


    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    //http://127.0.0.1:8080/products
    //Get all products
    @GetMapping("/all")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    //http://127.0.0.1:8080/product/52
    @GetMapping("/{id}")
     public Product getProduct(@PathVariable Long id){
         return repo.findById(id)
         .orElseThrow(()-> new ProductNotFoundException(id));
     }

//http:127.0.0.1:8080/product/new
    @PostMapping("/new")
    public String addProducts(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added Yey!";

    }

    //Update Endpoints
    //http://127.0.0.1:8080/product/edit/1
    @PutMapping("/edit/{id}")
    public Product updateProduct(@PathVariable Long id,
    @RequestBody Product newProduct){
        return repo.findById(id)
        .map(product ->{
            product.setProductname(newProduct.getProductname());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
    }

    //Delete Endpoints
    //http://127.0.0.1:8080/product/delete/1
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        repo.deleteById(id);
        return "A product is deleted";
    }

}
