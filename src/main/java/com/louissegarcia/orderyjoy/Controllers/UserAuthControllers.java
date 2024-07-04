package com.louissegarcia.orderyjoy.Controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louissegarcia.orderyjoy.DTO.RegistrationRequest;
import com.louissegarcia.orderyjoy.Model.Role;
import com.louissegarcia.orderyjoy.Model.UserAuth;
import com.louissegarcia.orderyjoy.Repository.RoleRepository;
import com.louissegarcia.orderyjoy.Repository.UserAuthRepository;

@RestController
@RequestMapping
public class UserAuthControllers {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){

        //Check if username exist in DB
        if (userAuthRepository.existByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already takenn", HttpStatus.BAD_REQUEST);
        }

        if (userAuthRepository.existByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already register in this email", HttpStatus.BAD_REQUEST);
        }

       UserAuth userAuth = new UserAuth(
         registrationRequest.getUsername(),
         registrationRequest.getEmail(),
         passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName( "Role_Admin").get();
        userAuth.setRoles(Collections.singleton(role));

        userAuthRepository.save(userAuth);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}

