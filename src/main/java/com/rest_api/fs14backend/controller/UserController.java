package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dto.AuthRequest;
import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("{id}")
    public User findUserByID(@PathVariable("id") UUID userId) {
        return userService.findById(userId).get();
    }

    @PostMapping("/signin")
    public String login(@RequestBody AuthRequest authRequest){
        return userService.login(authRequest);
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }
}
