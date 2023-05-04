package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.repository.UserRepository;
import com.rest_api.fs14backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> signup(){
        User user = new User("mughees", "admin");
        userRepository.save(user);
        return (List<User>) user;
    }

    @Override
    public String signin(){
        return "user signed in";
    }
}
