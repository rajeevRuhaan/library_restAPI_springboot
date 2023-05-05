package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.entity.Author;
import com.rest_api.fs14backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        ResponseEntity<String> res = null;
        try{
            UUID id = authorService.createAuthor(author);
            res = new ResponseEntity<String>("new Author created: " + author.getFirstName() +" " + author.getLastName(), HttpStatus.CREATED);
        } catch (Exception e) {
            res = new ResponseEntity<String>( "Unable to save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
                return res;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        List<Author> author = authorService.getAllAuthors();
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PutMapping("id")
    public ResponseEntity<Author> updateAuthor(@PathVariable UUID authorId, @RequestBody Author author){
        author.setId(authorId);
        Author updateAuthor = authorService.updateAuthor(author);
        return new ResponseEntity<>(updateAuthor, HttpStatus.OK);
    }

    @DeleteMapping("id")
    public  ResponseEntity<String>  deleteAuthor(@PathVariable("id") UUID authorId) {
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>("Author successfully deleted!", HttpStatus.OK);
    }

}
