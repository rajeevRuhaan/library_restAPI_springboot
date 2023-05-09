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
            Borrower borrower = borrowMapper.toBorrower(user, bookCopy);
            return borrowerRepository.save(borrower);

    }

    @Override
    public List<Borrower> getAllBorrower() {
        return borrowerRepository.findAll();
    }

    @Override
    public List<Borrower> findByUserId(UUID userId) {
        return null;
    }
}
