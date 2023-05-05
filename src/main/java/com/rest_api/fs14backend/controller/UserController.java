package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.repository.UserRepository;
import com.rest_api.fs14backend.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }

//    @PostMapping("/signup")
//    public List<User> signup(){
//        return userService.signup();
//    }
//
//    @PostMapping("/signin")
//    public String signin(){
//        return userService.signin();
//    }

}
