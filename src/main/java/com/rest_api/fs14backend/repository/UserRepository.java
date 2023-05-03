package com.rest_api.fs14backend.repository;

import com.rest_api.fs14backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
