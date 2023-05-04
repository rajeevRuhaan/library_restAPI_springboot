package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.entity.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BookCopyService {
    public List<BookCopy> getAll();
    public BookCopy getBookCopyById(UUID id);
    public BookCopy createOne(BookCopy bookCopy);


}
