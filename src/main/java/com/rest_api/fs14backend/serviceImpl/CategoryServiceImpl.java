package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.entity.Category;
import com.rest_api.fs14backend.repository.BookRepository;
import com.rest_api.fs14backend.repository.CategoryRepository;
import com.rest_api.fs14backend.service.BookService;
import com.rest_api.fs14backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;

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
    public void deleteOne(UUID categoryId) throws Exception {
        Book filteredBook = bookRepository.findAll().stream().filter(
                bookItem -> Objects.equals(bookItem.getCategory().getId(), categoryId)
        ).findFirst().orElse(null);
        if(null != filteredBook) {
            throw new Exception("Book is existed");
        }else {
        categoryRepository.deleteById(categoryId);
        }

    }
    public Category findCategoryById(UUID categoryId)  {
        return categoryRepository.findById(categoryId).get();
    }
}
