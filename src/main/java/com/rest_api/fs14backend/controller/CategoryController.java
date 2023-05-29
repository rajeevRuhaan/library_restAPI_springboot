package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.entity.Category;
import com.rest_api.fs14backend.exceptions.NotFoundException;
import com.rest_api.fs14backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @PutMapping("{categoryId}")
    public Category updateOne(@PathVariable UUID categoryId, @RequestBody Category updatedCategory) {
        updatedCategory.setId(categoryId);
        return categoryService.updateOne(updatedCategory);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody Category newCategory) {
        try {
            categoryService.createCategory(newCategory);
            return new ResponseEntity<>("New Category created", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>("Unable to save category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID categoryId) {
        try {
            categoryService.deleteOne(categoryId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "Error deleting category: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{categoryId}")
    public Category findById(@PathVariable UUID categoryId) {
        Category foundCategory = categoryService.findCategoryById(categoryId);
        if (foundCategory == null) {
            throw new NotFoundException("Category not found");
        }
        return foundCategory;
    }

}
