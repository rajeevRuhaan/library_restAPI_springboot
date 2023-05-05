package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

    public Borrower addBorrower(Borrower borrower) {
        Borrower newBorrower = new Borrower(borrower.getName(), borrower.getBookId());
        borrowerRepository.save(newBorrower);
        return newBorrower;
    }
}
