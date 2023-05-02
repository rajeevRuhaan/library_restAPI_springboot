package com.rest_api.fs14backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class testController {

    @GetMapping("")
    public String getTest() {
        return "This is test files.";
    }

}
