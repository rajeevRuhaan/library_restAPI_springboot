package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.entity.Category;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
     List<Category> findAll();

     Category updateOne(Category updatedCategory);

     void createCategory(Category newCategory);

     void deleteOne( UUID categoryId) throws Exception;
     Category findCategoryById(UUID categoryId);
}
