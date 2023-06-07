package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dto.BookCopyDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.BookCopy;


@Service
public interface BookCopyService {
     List<BookCopy> getAll();
     BookCopy findOne(UUID id);
     BookCopy createOne(BookCopyDto bookCopyDto);
     void deleteOne(UUID id);
     List<BookCopy>  findByBookId(UUID id);
}
