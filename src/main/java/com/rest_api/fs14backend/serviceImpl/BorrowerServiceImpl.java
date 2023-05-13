package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.dao.BorrowDao;
import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.entity.User;
import com.rest_api.fs14backend.mapper.BorrowMapper;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import com.rest_api.fs14backend.service.BookCopyService;
import com.rest_api.fs14backend.service.BorrowerService;
import com.rest_api.fs14backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    BorrowerRepository borrowerRepository;
    @Autowired
    UserService userService;
    @Autowired
    BookCopyService bookCopyService;
    @Autowired
    BorrowMapper borrowMapper;

    @Override
    public Borrower createOne(BorrowDao borrowDao) {

            UUID userId = borrowDao.getUserId();
            User user = userService.findById(userId).get();
            UUID bookCopyId = borrowDao.getBookCopyId();
            BookCopy bookCopy = bookCopyService.findOne(bookCopyId);
            // current date as borrow date
            Date borrowDate = new Date();
            // add 30 days return time
            Date returnDate =  new Date(borrowDate.getTime() + ((1000 * 60 * 60 * 24)* 30));
            Borrower borrower = borrowMapper.toBorrower(user, bookCopy, borrowDate, returnDate);
            return borrowerRepository.save(borrower);

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
    borrowerRepository.deleteById(borrowerId);
    }


}
