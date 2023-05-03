package com.rest_api.fs14backend.repository;

import com.rest_api.fs14backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
