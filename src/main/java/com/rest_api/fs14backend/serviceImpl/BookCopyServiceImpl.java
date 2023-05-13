package com.rest_api.fs14backend.serviceImpl;


import com.rest_api.fs14backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.repository.BookCopyRepository;
import com.rest_api.fs14backend.service.BookCopyService;
import com.rest_api.fs14backend.dao.BookCopyDto;
import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.mapper.BookCopyMapper;


@Service
public class BookCopyServiceImpl implements BookCopyService {
    @Autowired
    BookService bookService;
    @Autowired
    BookCopyRepository bookCopyRepository;
    @Autowired
    BookCopyMapper bookCopyMapper;

    @Override
    public List<BookCopy> getAll(){
        return bookCopyRepository.findAll();
    }

    @Override
    public BookCopy findOne(UUID id){
        return bookCopyRepository.findById(id).orElse(null);
    }

    @Override
    public BookCopy createOne(BookCopyDto bookCopyDto){
        UUID bookId = bookCopyDto.getBookId();
        Book book = bookService.findOne(bookId);

        BookCopy bookCopy = bookCopyMapper.toBookCopy(book);
        return bookCopyRepository.save(bookCopy);
    }

    @Override
    public void deleteOne(UUID id){
        bookCopyRepository.deleteById(id);
    }

}
