package com.faldetta.financebackend.service;

import com.faldetta.financebackend.entity.Transaction;
import com.faldetta.financebackend.entity.TransactionType;
import com.faldetta.financebackend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get transactions for a specific user
    public List<Transaction> getTransactionsByUser(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    // Total Income
    public Double getTotalIncome(Long userId) {
        return transactionRepository
                .findByUserIdAndType(userId, TransactionType.INCOME)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
   // Total Expenses
    public Double getTotalExpenses(Long userId) {
        return transactionRepository
                .findByUserIdAndType(userId, TransactionType.EXPENSE)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
    // Balence Calculation
    public Double getBalance(Long userId) {
        return getTotalIncome(userId) - getTotalExpenses(userId);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}