package com.rest_api.fs14backend.repository;

import com.rest_api.fs14backend.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
