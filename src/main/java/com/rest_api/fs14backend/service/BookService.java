package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dto.BookDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;

@Service
public interface BookService {
    public List<Book> findAll();
    public Book findOne(UUID id);
    public Book createOne(BookDto bookDto);
    public Book updateOne(UUID id, BookDto bookDto);
    public void deleteOne(UUID id);
}
