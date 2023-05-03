package com.rest_api.fs14backend.controller;


import com.rest_api.fs14backend.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.rest_api.fs14backend.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping("/")
    public Book createOne(@RequestBody Book book) {
        return bookService.createOne(book);
    }


}
