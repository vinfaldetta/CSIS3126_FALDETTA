package com.faldetta.financebackend.repository;

import com.faldetta.financebackend.entity.Transaction;
import com.faldetta.financebackend.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByUserIdAndType(Long userId, TransactionType type);
}