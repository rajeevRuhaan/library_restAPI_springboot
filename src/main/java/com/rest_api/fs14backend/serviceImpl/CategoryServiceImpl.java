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
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateOne(Category updatedCategory) {
        Category category = categoryRepository.findById(updatedCategory.getId()).get();
        category.setName(updatedCategory.getName());

        return categoryRepository.save(category);
    }

    @Override
    public Category addOne(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteOne(UUID categoryId) throws Exception {
        Optional<Book> filteredBook = bookRepository.findAll().stream().filter(
                bookItem -> Objects.equals(bookItem.getCategory().getId(), categoryId)
        ).findFirst();
        if (filteredBook.isPresent()) {
            throw new Exception("Book is associated with the category");
        } else {
           Optional<Category> category =  categoryRepository.findById(categoryId);
           if (category.isPresent()) {
               categoryRepository.delete(category.get());
           } else {
               throw new Exception("Category not found");
           }
        }

    }

    public Category findCategoryById(UUID categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
}
