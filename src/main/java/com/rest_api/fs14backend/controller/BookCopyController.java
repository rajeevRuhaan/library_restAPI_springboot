package com.rest_api.fs14backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.dao.BookCopyDto;
import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.mapper.BookCopyMapper;
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
    @PostMapping()
    public BookCopy createOne(@RequestBody BookCopyDto bookCopyDto){
        return bookCopyService.createOne(bookCopyDto);
    }
    @DeleteMapping("/deleteBookCopy/{id}/")
    public void deleteOne(@PathVariable UUID id){
         bookCopyService.deleteOne(id);
    }

}
