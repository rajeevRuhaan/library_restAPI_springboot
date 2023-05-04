package com.rest_api.fs14backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping()
    public Book createOne(@RequestBody Book book) {
        return bookService.createOne(book);
    }

    @GetMapping("/{id}/")
    public Book getOne(@PathVariable UUID id){
        return bookService.findOne(id);
    }
   @PutMapping("/updateBook/{id}/")
    public Book updateOne(@PathVariable UUID id,@RequestBody Book book){
        return bookService.updateOne(id,book);
    }

    @DeleteMapping("/deleteBook/{id}/")
    public void deleteOne(@PathVariable UUID id){
            bookService.deleteOne(id);
    }

}
