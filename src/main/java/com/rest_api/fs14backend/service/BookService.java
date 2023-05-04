package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public interface BookService {
    public List<Book> findAll();
    public Book findOne(UUID id);
    public Book createOne(Book book);
    public Book updateOne(UUID id,Book book);
    public void deleteOne(UUID id);
}
