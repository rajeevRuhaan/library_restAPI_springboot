package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.entity.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    UUID createAuthor(Author author);
    Author getUserById(UUID authorId);
    List<Author> getAllAuthors();
    Author updateAuthor(Author author, UUID authorId);
    void deleteAuthor(UUID authorId);
}
