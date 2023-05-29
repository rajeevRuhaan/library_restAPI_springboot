package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dto.AuthRequestDto;
import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.repository.UserRepository;
import com.rest_api.fs14backend.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("{id}")
    public User findUserByID(@PathVariable("id") UUID userId) {
        return userService.findById(userId).get();
    }

    @PostMapping("/signin")
    public ResponseEntity<String> login(@RequestBody AuthRequestDto authRequestDto){
        try {
            String token = userService.login(authRequestDto);
            return ResponseEntity.ok(token);
        } catch (AuthenticationException ex) {
            // Handle other authentication errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication failed");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup( @RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<>("Request body is empty!", HttpStatus.BAD_REQUEST);
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return new ResponseEntity<>("Username is required!", HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return new ResponseEntity<>("Password is required!", HttpStatus.BAD_REQUEST);
        }
        // add check for username or email exists in a DB
        if(userRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        userService.signup(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
