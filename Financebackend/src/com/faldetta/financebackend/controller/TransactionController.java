package com.faldetta.financebackend.controller;

import com.faldetta.financebackend.entity.Transaction;
import com.faldetta.financebackend.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }
}