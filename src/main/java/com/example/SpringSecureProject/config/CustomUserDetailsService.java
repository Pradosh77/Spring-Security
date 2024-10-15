package com.example.SpringSecureProject.config;

import com.example.SpringSecureProject.entity.User;
import com.example.SpringSecureProject.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found" +  username);
        }


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())  // password is already hashed
                .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")))  // Default to "ROLE_ADMIN" // Default to "ROLE_ADMIN"
                .build();
    }
}
