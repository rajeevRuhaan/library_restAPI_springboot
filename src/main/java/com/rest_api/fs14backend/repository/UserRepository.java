package com.rest_api.fs14backend.repository;

import com.rest_api.fs14backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);

}
