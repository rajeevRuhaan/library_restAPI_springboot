package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.dto.BookDto;
import com.rest_api.fs14backend.entity.Author;
import com.rest_api.fs14backend.entity.Category;
import com.rest_api.fs14backend.mapper.BookMapper;
import com.rest_api.fs14backend.service.AuthorService;
import com.rest_api.fs14backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.repository.BookRepository;
import com.rest_api.fs14backend.service.BookService;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findOne(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createOne(BookDto bookDto) {
        System.out.println(bookDto);
        UUID authorId = bookDto.getAuthorId();
        Optional<Author> foundAuthor = Optional.ofNullable(authorService.getAuthorById(authorId));
        if (foundAuthor.isPresent()) {
            System.out.println("author");
            throw new IllegalArgumentException("Author not found");
        }

        UUID categoryId = bookDto.getCategoryId();
        Category foundCategory = categoryService.findCategoryById(categoryId);
        if (foundCategory == null) {
            System.out.println("category");
            throw new IllegalArgumentException("Category not found");
        }

        Book newBook = bookMapper.toBook(bookDto, foundCategory, foundAuthor.get());
        return bookRepository.save(newBook);
    }

    @Override
    public Book updateOne(UUID id, BookDto bookDto) {
        Book foundBook = bookRepository.findById(id).orElse(null);
        UUID authorId = bookDto.getAuthorId();
        Author foundAuthor = authorService.getAuthorById(authorId);
        UUID categoryId = bookDto.getCategoryId();
        Category foundCategory = categoryService.findCategoryById(categoryId);

        if (foundBook != null) {
            foundBook.setIsbn(bookDto.getIsbn());
            foundBook.setTitle(bookDto.getTitle());
            foundBook.setAuthor(foundAuthor);
            foundBook.setCategory(foundCategory);
            foundBook.setPublishedDate(bookDto.getPublishedDate());
            foundBook.setPublisher(bookDto.getPublisher());
            foundBook.setCoverImageUrl(bookDto.getCoverImageUrl());
            return bookRepository.save(foundBook);
        }
        return null;
    }

    @Override
    public void deleteOne(UUID id) {
        bookRepository.deleteById(id);
    }
}
