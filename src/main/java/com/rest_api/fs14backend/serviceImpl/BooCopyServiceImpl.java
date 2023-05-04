package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.repository.BookCopyRepository;
import com.rest_api.fs14backend.service.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BooCopyServiceImpl implements BookCopyService {

    @Autowired
    BookCopyRepository bookCopyRepository;
    @Override
    public List<BookCopy> getAll(){
        return bookCopyRepository.findAll();
    }

    @Override
    public BookCopy getBookCopyById(UUID id){
        return bookCopyRepository.findById(id).orElse(null);
    }

    @Override
    public BookCopy createOne(BookCopy bookCopy){
        return bookCopyRepository.save(bookCopy);
    }

}
