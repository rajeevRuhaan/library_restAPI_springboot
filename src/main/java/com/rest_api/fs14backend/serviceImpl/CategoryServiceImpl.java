package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.entity.Category;
import com.rest_api.fs14backend.repository.CategoryRepository;
import com.rest_api.fs14backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateOne(Category updatedCategory) {
        Category category = categoryRepository.findById(updatedCategory.getId()).get();
//                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        category.setName(updatedCategory.getName());

        return categoryRepository.save(category);
    }

    @Override
    public Category addOne(Category newCategory){
        Category category = new Category();
        category.setName(newCategory.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteOne(UUID categoryId)  {
        categoryRepository.deleteById(categoryId);
    }
}
