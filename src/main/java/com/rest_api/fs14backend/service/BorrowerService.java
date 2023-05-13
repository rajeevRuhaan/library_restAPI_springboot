package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dao.BorrowDao;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


public interface BorrowerService {

     void createOne(BorrowDao borrowDao);
     List<Borrower> getAllBorrower();
     List<Borrower> findAllByUserId( UUID userId);
     void deleteOne(UUID borrowerId);
}
