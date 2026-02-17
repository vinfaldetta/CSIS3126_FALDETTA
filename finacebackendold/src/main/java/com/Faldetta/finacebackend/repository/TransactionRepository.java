package com.Faldetta.finacebackend.repository;

import com.Faldetta.finacebackend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
}