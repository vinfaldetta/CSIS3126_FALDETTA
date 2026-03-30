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

    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }

    @GetMapping("/{userId}")
    public List<Income> getIncomeByUser(@PathVariable Long userId) {
        return incomeRepository.findByUser_Id(userId); // ✅ FIXED
    }
    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeRepository.deleteById(id);
    }
}