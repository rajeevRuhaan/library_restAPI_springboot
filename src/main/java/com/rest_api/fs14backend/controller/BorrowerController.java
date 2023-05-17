package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dto.BorrowDto;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @PostMapping
    public ResponseEntity<String> createOne(@RequestBody BorrowDto borrowDto) {
        try {
            borrowerService.createOne(borrowDto);
            return new ResponseEntity<>("borrower created: ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to borrow", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public ResponseEntity<List<Borrower>> getAllBorrower() {
        try {
            List<Borrower> borrowerList = borrowerService.getAllBorrower();
            return new ResponseEntity<>(borrowerList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<List<Borrower>> getAllByUserId(@PathVariable("id") UUID userId) {
        try {
            List<Borrower> borrowerList = borrowerService.findAllByUserId(userId);
            return new ResponseEntity<>(borrowerList, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBorrower(@PathVariable("id") UUID borrowerId) {
        try {
            borrowerService.deleteOne(borrowerId);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
