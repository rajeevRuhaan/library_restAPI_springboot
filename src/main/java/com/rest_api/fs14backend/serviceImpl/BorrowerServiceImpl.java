package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.dto.BorrowDto;
import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.mapper.BorrowMapper;
import com.rest_api.fs14backend.repository.BookCopyRepository;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import com.rest_api.fs14backend.service.BookCopyService;
import com.rest_api.fs14backend.service.BorrowerService;
import com.rest_api.fs14backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    BookCopyRepository bookCopyRepository;
    @Autowired
    BorrowerRepository borrowerRepository;
    @Autowired
    UserService userService;
    @Autowired
    BookCopyService bookCopyService;
    @Autowired
    BorrowMapper borrowMapper;

    @Override
    public void createOne(BorrowDto borrowDto) {

        UUID userId = borrowDto.getUserId();
        User user = userService.findById(userId).get();
        UUID bookCopyId = borrowDto.getBookCopyId();
        BookCopy bookCopy = bookCopyService.findOne(bookCopyId);
        // current date as borrow date
        Date borrowDate = new Date();
        // add 30 days return time
        Date returnDate = new Date(borrowDate.getTime() + ((1000 * 60 * 60 * 24) * 30));
        if (bookCopy != null) {
            Borrower borrower = borrowMapper.toBorrower(user, bookCopy, borrowDate, returnDate);
            bookCopy.setIsAvailable(false);
            bookCopyRepository.save(bookCopy);
            borrowerRepository.save(borrower);
        } else {
            throw new RuntimeException("Book is not available");
        }


    }

    @Override
    public List<Borrower> getAllBorrower() {
        return borrowerRepository.findAll();
    }

    @Override
    public List<Borrower> findAllByUserId(UUID userId) {
        return borrowerRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteOne(UUID borrowerId) {
        Borrower foundBorrower = borrowerRepository.findById(borrowerId).orElse(null);
        if (foundBorrower != null) {
            UUID foundBookCopyId = foundBorrower.getBookCopy().getId();
            BookCopy foundBookCopy = bookCopyRepository.findById(foundBookCopyId).orElse(null);

            if (foundBookCopy != null) {
                foundBookCopy.setIsAvailable(true);
                bookCopyRepository.save(foundBookCopy);
            }
            borrowerRepository.deleteById(borrowerId);
        }
    }


}
