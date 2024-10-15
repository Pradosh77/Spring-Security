package com.example.SpringSecureProject.controller;


import com.example.SpringSecureProject.entity.User;
import com.example.SpringSecureProject.serivces.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/login")
    public User saveUserForLogin(@RequestBody User user){
        return userService.save(user);
    }

}
