package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dto.AuthRequestDto;
import com.rest_api.fs14backend.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
     List<User> findAll();
     Optional<User> findById(UUID userId);
     User signup(User user);
     String login(AuthRequestDto authRequestDto);
}
