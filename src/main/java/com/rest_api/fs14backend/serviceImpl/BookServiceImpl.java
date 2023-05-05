package com.rest_api.fs14backend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.repository.BookRepository;
import com.rest_api.fs14backend.service.BookService;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book findOne (UUID id){
        System.out.println("##### " + bookRepository.findById(id));
        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public Book createOne(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateOne(UUID id,Book book){
       Book foundBook =  bookRepository.findById(id).orElse(null);

       if(foundBook != null){ foundBook.setIsbn(book.getIsbn());
           foundBook.setTitle(book.getTitle());
           foundBook.setAuthor(book.getAuthor());
           foundBook.setCategory(book.getCategory());
           foundBook.setPublishedDate(book.getPublishedDate());
           foundBook.setPublisher(book.getPublisher());
           foundBook.setCover(book.getCover());
           return bookRepository.save(foundBook);
       }
      return null;
    }

    @Override
    public void deleteOne(UUID id){
        bookRepository.deleteById(id);
    }
}
