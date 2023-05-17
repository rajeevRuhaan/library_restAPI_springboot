package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> findAll() {
        try {
            List<Book> bookList = bookService.findAll();
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
        try {
            Book createdBook = bookService.createOne(bookDto);
            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getOne(@PathVariable UUID id) {
        try {
            Book book = bookService.findOne(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public Book updateOne(@PathVariable UUID id, @RequestBody BookDto bookDto) {
        return bookService.updateOne(id, bookDto);
    }

    @DeleteMapping("{id}")
    public void deleteOne(@PathVariable UUID id) {
        bookService.deleteOne(id);
    }

}
