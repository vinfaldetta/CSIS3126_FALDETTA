package com.faldetta.financebackend.controller;

import com.faldetta.financebackend.entity.Expense;
import com.faldetta.financebackend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @GetMapping("/{userId}")
    public List<Expense> getExpensesByUser(@PathVariable Long userId) {
        return expenseRepository.findByUser_Id(userId); // ✅ FIXED
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
    }
}