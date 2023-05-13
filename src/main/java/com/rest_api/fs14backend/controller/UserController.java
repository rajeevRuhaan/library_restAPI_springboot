package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dao.AuthRequest;
import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.repository.UserRepository;
import com.rest_api.fs14backend.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/signin")
    public String login(@RequestBody AuthRequest authRequest){
        return userService.login(authRequest);
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }
}
