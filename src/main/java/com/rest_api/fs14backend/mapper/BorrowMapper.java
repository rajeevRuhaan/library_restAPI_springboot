package com.rest_api.fs14backend.mapper;

import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
@Component
public class BorrowMapper {
    public Borrower toBorrower(User user, BookCopy bookCopy, Date borrowDate, Date returnDate) {
        return new Borrower(user, bookCopy, borrowDate, returnDate );
    }
}
