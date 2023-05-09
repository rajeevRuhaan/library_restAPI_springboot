package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dao.BorrowDao;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import com.rest_api.fs14backend.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/borrower")
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    @PostMapping
    public ResponseEntity<String> createOne(@RequestBody BorrowDao borrowDao) {
         System.out.println(borrowDao);
         ResponseEntity<String> res = null;
         try{
            Borrower borrower =  borrowerService.createOne(borrowDao);
             res = new ResponseEntity<String>("borrower created: " + borrower, HttpStatus.CREATED);
         } catch (Exception e) {
             res = new ResponseEntity<String>("Unable to borrow", HttpStatus.INTERNAL_SERVER_ERROR);
         }
         return res;
    }

    @GetMapping
    public List<Borrower> getAllBorrower() {
        List<Borrower> borrowerList = borrowerService.getAllBorrower();
        return borrowerList ;
    }

}
