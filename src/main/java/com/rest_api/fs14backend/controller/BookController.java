package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dto.BookDto;
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
    public Book createOne(@RequestBody BookDto bookDto) {
        return bookService.createOne(bookDto);
    }

    @GetMapping("{id}")
    public Book getOne(@PathVariable UUID id){
        return bookService.findOne(id);
    }
   @PutMapping("{id}")
    public Book updateOne(@PathVariable UUID id,@RequestBody BookDto bookDto){
        return bookService.updateOne(id, bookDto);
    }

    @DeleteMapping("{id}")
    public void deleteOne(@PathVariable UUID id){
            bookService.deleteOne(id);
    }

}
