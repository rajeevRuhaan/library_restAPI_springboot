package com.rest_api.fs14backend.serviceImpl;


import com.rest_api.fs14backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.repository.BookCopyRepository;
import com.rest_api.fs14backend.service.BookCopyService;
import com.rest_api.fs14backend.dto.BookCopyDto;
import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.mapper.BookCopyMapper;


@Service
public class BookCopyServiceImpl implements BookCopyService {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookCopyRepository bookCopyRepository;
    @Autowired
    private BookCopyMapper bookCopyMapper;

    @Override
    public List<BookCopy> getAll() {
        return bookCopyRepository.findAll();
    }

    @Override
    public BookCopy findOne(UUID id) {
        return bookCopyRepository.findById(id).orElse(null);
    }

    @Override
    public BookCopy createOne(BookCopyDto bookCopyDto) {
        UUID bookId = bookCopyDto.getBookId();
        Book book = bookService.findOne(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        BookCopy bookCopy = bookCopyMapper.toBookCopy(book);
        return bookCopyRepository.save(bookCopy);
    }

    @Override
    public void deleteOne(UUID id) {
        bookCopyRepository.deleteById(id);
    }

    @Override
    public List<BookCopy> findByBookId(UUID id) {
        List<BookCopy>  filterBookCopies = new ArrayList<>();

        List<BookCopy>  allBookCopies = bookCopyRepository.findAll();
       for (BookCopy bookCopy: allBookCopies) {
           if(bookCopy.getBook().getId().equals(id)) {
               filterBookCopies.add(bookCopy);
           }
       }
        return filterBookCopies;
    }

}
