package com.example.MongoDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping
    public String testUrl(){
        return "Updated customers feature in main branch";
    }
}
