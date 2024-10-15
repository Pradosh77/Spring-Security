package com.example.SpringSecureProject.serivces;


import com.example.SpringSecureProject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User save(User users);

    List<User> getAllUsers();

}
