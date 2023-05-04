package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.entity.Category;
import com.rest_api.fs14backend.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public List<User> findAll();

    public List<User> signup();

    public String signin();
}
