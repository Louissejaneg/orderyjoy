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

import com.louissegarcia.orderyjoy.Model.Users;
import com.louissegarcia.orderyjoy.NotFoundException.UsersNotFoundException;
import com.louissegarcia.orderyjoy.Repository.UsersRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UsersController {

    final UsersRepository repo;


    public UsersController(UsersRepository repo) {
        this.repo = repo;
    }

    //http://127.0.0.1:8080/Users
    //Get all users
    @GetMapping("/all")
    public List<Users> getUsers(){
        return repo.findAll();
    }

    //http://127.0.0.1:8080/Users/52
    @GetMapping("/{id}")
     public Users getUsers(@PathVariable Long id){
         return repo.findById(id)
         .orElseThrow(()-> new UsersNotFoundException(id));
     }

//http:127.0.0.1:8080/Users/new
    @PostMapping("/new")
    public String addUse(@RequestBody Users newUsers){
        repo.save(newUsers);
        return "A new users is added Yey!";

    }

    //Update Endpoints
    //http://127.0.0.1:8080/users/edit/1
    @PutMapping("/edit/{id}")
    public Users updateUsers(@PathVariable Long id,
    @RequestBody Users newUsers){
        return repo.findById(id)
        .map(users ->{
            users.setusername(newUsers.getusername());
            users.setaddress(newUsers.getaddress());
            users.setage(newUsers.getage());
            return repo.save(users);
        }).orElseGet(()->{
            return repo.save(newUsers);
        });
    }

    //Delete Endpoints
    //http://127.0.0.1:8080/users/delete/1
    @DeleteMapping("/delete/{id}")
    public String deleteusers(@PathVariable Long id){
        repo.deleteById(id);
        return "A users is deleted";
    }

}
