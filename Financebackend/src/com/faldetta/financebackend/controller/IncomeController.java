package com.faldetta.financebackend.controller;

import com.faldetta.financebackend.entity.Income;
import com.faldetta.financebackend.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    // SAVE income
    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }

    // GET all income
    @GetMapping
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    // DELETE income
    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeRepository.deleteById(id);
    }
}