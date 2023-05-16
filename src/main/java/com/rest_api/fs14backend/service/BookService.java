package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dto.BookDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;

@Service
public interface BookService {
     List<Book> findAll();
     Book findOne(UUID id);
     Book createOne(BookDto bookDto);
     Book updateOne(UUID id, BookDto bookDto);
     void deleteOne(UUID id);
}
