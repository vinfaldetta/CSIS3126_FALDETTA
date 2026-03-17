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

    @GetMapping
    public DashboardSummary getDashboardSummary() {

        double totalIncome = incomeRepository.findAll()
                .stream()
                .mapToDouble(income -> income.getAmount())
                .sum();

        double totalExpenses = expenseRepository.findAll()
                .stream()
                .mapToDouble(expense -> expense.getAmount())
                .sum();

        return new DashboardSummary(totalIncome, totalExpenses);
    }
}
