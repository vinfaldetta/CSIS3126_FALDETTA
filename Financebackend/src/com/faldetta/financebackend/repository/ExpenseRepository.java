package com.faldetta.financebackend.repository;

import com.faldetta.financebackend.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    }

