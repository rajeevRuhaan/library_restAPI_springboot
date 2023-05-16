package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dto.BorrowDto;
import com.rest_api.fs14backend.entity.Borrower;


import java.util.List;
import java.util.UUID;


public interface BorrowerService {

     void createOne(BorrowDto borrowDto);
     List<Borrower> getAllBorrower();
     List<Borrower> findAllByUserId( UUID userId);
     void deleteOne(UUID borrowerId);
}
