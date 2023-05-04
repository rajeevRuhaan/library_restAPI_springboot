package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public List<User> signup(){
        User user = new User("mughees", "admin");
        userRepository.save(user);
        return (List<User>) user;
    }

    @PostMapping("/signin")
    public String signin(){
        return "user signed in";
    }

}
