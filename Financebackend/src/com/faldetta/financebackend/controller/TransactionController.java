package com.faldetta.financebackend.controller;

import com.faldetta.financebackend.entity.Transaction;
import com.faldetta.financebackend.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // GET all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionService.getAllTransactions()
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUser(@PathVariable Long userId) {
        return transactionService.getTransactionsByUser(userId);
    }

    //  Financial Summary
    @GetMapping("/summary/{userId}")
    public Map<String, Double> getSummary(@PathVariable Long userId) {

        Double income = transactionService.getTotalIncome(userId);
        Double expenses = transactionService.getTotalExpenses(userId);
        Double balance = transactionService.getBalance(userId);

        Map<String, Double> summary = new HashMap<>();
        summary.put("totalIncome", income);
        summary.put("totalExpenses", expenses);
        summary.put("balance", balance);

        return summary;
    }
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "Transaction deleted";
    }
}