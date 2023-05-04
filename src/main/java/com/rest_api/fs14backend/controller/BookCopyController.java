package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.repository.BookRepository;
import com.rest_api.fs14backend.service.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookCopies")
public class BookCopyController {
    @Autowired
    BookCopyService bookCopyService;


    @GetMapping()
    public List<BookCopy> findAll(){
       return bookCopyService.getAll();
    }

    @PostMapping()
    public BookCopy createOne(@RequestBody BookCopy bookCopy){
        return bookCopyService.createOne(bookCopy);
    }


}
