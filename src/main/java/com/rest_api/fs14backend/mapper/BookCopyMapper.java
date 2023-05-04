package com.rest_api.fs14backend.mapper;

import org.springframework.stereotype.Component;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.entity.BookCopy;

@Component
public class BookCopyMapper {
    public BookCopy toBookCopy(Book book){
        return new BookCopy(book);
    }
}
