package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dao.BookCopyDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.BookCopy;


@Service
public interface BookCopyService {
    public List<BookCopy> getAll();
    public BookCopy findOne(UUID id);
    public BookCopy createOne(BookCopyDto bookCopyDto);
    public void deleteOne(UUID id);
}
