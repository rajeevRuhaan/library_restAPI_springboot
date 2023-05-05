package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import com.rest_api.fs14backend.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/borrowers")
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    @Autowired
    BorrowerRepository borrowerRepository;

    @GetMapping("/findAll")
    public List<Borrower> findAll() {
        return borrowerService.findAll();
    }
    @PostMapping("/add")
    public Borrower addBorrower(@RequestBody Borrower borrower) {
       return  borrowerService.addBorrower(borrower);

    }

}
