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

    // GET all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // New transaction
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return repo.save(transaction);
    }

    // DELETE transaction
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        repo.deleteById(id);
        return "Transaction deleted";
    }
}