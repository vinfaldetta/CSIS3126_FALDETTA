package com.Faldetta.finacebackend.service;

import com.Faldetta.finacebackend.entity.Transaction;
import com.Faldetta.finacebackend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Create or update a transaction
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get transactions for a specific user
    public List<Transaction> getTransactionsByUser(Long userId) {
        return transactionRepository.findAll()
                .stream()
                .filter(t -> t.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    // Delete a transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
