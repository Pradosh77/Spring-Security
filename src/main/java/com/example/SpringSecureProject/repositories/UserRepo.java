package com.example.SpringSecureProject.repositories;

import com.example.SpringSecureProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<com.example.SpringSecureProject.entity.User,String> {
    User findByUsername(String username);
}
