package com.example.expenses.controller;

import com.example.expenses.dto.MonthlyTotalDto;
import com.example.expenses.model.Expense;
import com.example.expenses.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseRestController {

    private final ExpenseRepository repository;

    public ExpenseRestController(ExpenseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Expense> all() {
        return repository.findAll();
    }

    @GetMapping("/api/expenses/monthly")
    public List<MonthlyTotalDto> monthlyTotals() {
        return repository.monthlyTotals();
    }
}
