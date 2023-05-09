package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.entity.Category;
import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.repository.CategoryRepository;
import com.rest_api.fs14backend.repository.UserRepository;
import com.rest_api.fs14backend.serviceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @PutMapping("{categoryId}")
    public Category updateOne(@PathVariable UUID categoryId, @RequestBody Category updatedCategory) {
        updatedCategory.setId(categoryId);
        return categoryService.updateOne(updatedCategory);
    }

    @PostMapping
    public Category addOne(@RequestBody Category newCategory) {
        return categoryService.addOne(newCategory);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID categoryId) {
        categoryService.deleteOne(categoryId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{categoryId}")
    public Category findById(@PathVariable UUID categoryId) {
       return categoryService.findCategoryById(categoryId);
    }

}
