package com.faldetta.financebackend.controller;

import com.faldetta.financebackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/")
    public String home() {
        return "Finance Backend is Running!";
    }

    @GetMapping("/dbtest")
    public String dbTest() {
        long count = transactionRepository.count(); // REAL DB QUERY
        return "Database connected! Transactions in DB: " + count;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello Vincent!";
    }
}