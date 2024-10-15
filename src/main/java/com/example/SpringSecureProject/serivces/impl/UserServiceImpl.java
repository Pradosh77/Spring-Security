package com.example.SpringSecureProject.serivces.impl;

import com.example.SpringSecureProject.entity.User;
import com.example.SpringSecureProject.repositories.UserRepo;
import com.example.SpringSecureProject.serivces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        user.setId(String.valueOf(UUID.randomUUID()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
