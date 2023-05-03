package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book createOne(Book book) {
        return bookRepository.save(book);
    }

}
