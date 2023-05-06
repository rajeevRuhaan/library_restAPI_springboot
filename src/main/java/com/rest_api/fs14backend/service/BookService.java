package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dao.BookDao;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;

@Service
public interface BookService {
    public List<Book> findAll();
    public Book findOne(UUID id);
    public Book createOne(BookDao bookDao);
    public Book updateOne(UUID id,BookDao bookDao);
    public void deleteOne(UUID id);
}
