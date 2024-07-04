package com.louissegarcia.orderyjoy.Service;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import com.louissegarcia.orderyjoy.Model.UserAuth;
import com.louissegarcia.orderyjoy.Repository.UserAuthRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
    
    private UserAuthRepository userAuthRepository;

    public CustomUserDetailService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public UserDetails loadUserByUsername(String usernameOrEmal) throws UsernameNotFoundException{
       UserAuth userAuth = userAuthRepository.findByUsernameOrEmail(usernameOrEmal, usernameOrEmal) 
           .orElseThrow(() ->
        new UsernameNotFoundException("User not found with username or emial" + usernameOrEmal));

        Set<GrantedAuthority> authorities = userAuth
            .getRoles()
            .stream()
            .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

            return new org.springframework.security.core.userdetails.User(
                userAuth.getEmail(),
                userAuth.getPassword(),
                authorities
            );    

    }


}
