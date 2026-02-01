package com.example.expenses.controller;

import com.example.expenses.dto.ExpenseRequest;
import com.example.expenses.model.Category;
import com.example.expenses.model.Expense;
import com.example.expenses.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    @GetMapping("/")
    public String index(Model model) {

        List<Expense> expenses = expenseRepository.findAll();

        BigDecimal total = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("total", total);
        model.addAttribute("expenses", expenses);
        model.addAttribute("categories", Category.values());
        model.addAttribute("expenseRequest", new ExpenseRequest());

        return "index";
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute ExpenseRequest expenseRequest) {

        Expense expense = new Expense();
        expense.setAmount(expenseRequest.getAmount());
        expense.setCategory(expenseRequest.getCategory());
        expense.setCreatedAt(LocalDateTime.now());

        expenseRepository.save(expense);

        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/";
    }
}

