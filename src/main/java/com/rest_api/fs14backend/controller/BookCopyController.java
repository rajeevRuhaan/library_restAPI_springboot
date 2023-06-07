package com.rest_api.fs14backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.dto.BookCopyDto;
import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.service.BookCopyService;
import com.rest_api.fs14backend.service.BookService;


@RestController
@RequestMapping("/api/v1/bookCopies")
public class BookCopyController {
    @Autowired
    BookCopyService bookCopyService;
    @Autowired
    BookService bookService;
    @GetMapping()
    public List<BookCopy> findAll(){
        return bookCopyService.getAll();
    }
    @GetMapping("/{id}")
    public List<BookCopy> findById(@PathVariable UUID id) {
        return bookCopyService.findByBookId(id);
    }
    @PostMapping()
    public ResponseEntity<?> createOne(@RequestBody BookCopyDto bookCopyDto){
        try {
            bookCopyService.createOne(bookCopyDto);
            return new ResponseEntity<>("Book copy created", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("{id}")
    public void deleteOne(@PathVariable UUID id){

        bookCopyService.deleteOne(id);
    }

}
