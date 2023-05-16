package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.dto.AuthRequest;
import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.repository.UserRepository;
import com.rest_api.fs14backend.service.UserService;
import com.rest_api.fs14backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public String login(AuthRequest authRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(authRequest.getUsername());
        return jwtUtils.generateToken(user);

    }

    @Override
    public User signup(User user) {
        User newUser = new User(user.getUsername(), user.getRole(),  passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
        return newUser;
    }

}
