package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.dao.BookDao;
import com.rest_api.fs14backend.entity.Author;
import com.rest_api.fs14backend.entity.Category;
import com.rest_api.fs14backend.mapper.BookMapper;
import com.rest_api.fs14backend.service.AuthorService;
import com.rest_api.fs14backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.repository.BookRepository;
import com.rest_api.fs14backend.service.BookService;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book findOne (UUID id){
        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public Book createOne(BookDao bookDao) {
        UUID authorId = bookDao.getAuthorID();
        Author foundAuthor = authorService.getUserById(authorId);
        UUID categoryId = bookDao.getCategoryId();
        Category foundCategory = categoryService.findCategoryById(categoryId);
        Book newBook  =  bookMapper.toBook(bookDao,foundCategory,foundAuthor);
        return bookRepository.save(newBook);
    }

    @Override
    public Book updateOne(UUID id,BookDao bookDao){
       Book foundBook =  bookRepository.findById(id).orElse(null);
        UUID authorId = bookDao.getAuthorID();
        Author foundAuthor = authorService.getUserById(authorId);
        UUID categoryId = bookDao.getCategoryId();
        Category foundCategory = categoryService.findCategoryById(categoryId);

       if(foundBook != null){
           foundBook.setIsbn(bookDao.getIsbn());
           foundBook.setTitle(bookDao.getTitle());
           foundBook.setAuthor(foundAuthor);
           foundBook.setCategory(foundCategory);
           foundBook.setPublishedDate(bookDao.getPublishedDate());
           foundBook.setPublisher(bookDao.getPublisher());
           foundBook.setCoverImageUrl(bookDao.getCoverImageUrl());
           return bookRepository.save(foundBook);
       }
      return null;
    }

    @Override
    public void deleteOne(UUID id){
        bookRepository.deleteById(id);
    }
}
