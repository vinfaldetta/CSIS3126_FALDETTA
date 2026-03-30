package com.faldetta.financebackend.controller;

import com.faldetta.financebackend.dto.DashboardSummary;
import com.faldetta.financebackend.repository.IncomeRepository;
import com.faldetta.financebackend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    // ✅ FIXED: user-specific dashboard
    @GetMapping("/{userId}")
    public DashboardSummary getDashboardSummary(@PathVariable Long userId) {

        double totalIncome = incomeRepository.findByUser_Id(userId)
                .stream()
                .mapToDouble(income -> income.getAmount())
                .sum();

        double totalExpenses = expenseRepository.findByUser_Id(userId)
                .stream()
                .mapToDouble(expense -> expense.getAmount())
                .sum();

        double balance = totalIncome - totalExpenses;

        return new DashboardSummary(totalIncome, totalExpenses, balance);
    }
}