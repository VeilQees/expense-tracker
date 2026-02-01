package com.example.expenses.service;

import com.example.expenses.model.Expense;
import com.example.expenses.model.SortType;
import com.example.expenses.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository repository;

    public List<Expense> getSorted(String sortParam) {
        SortType sortType = SortType.from(sortParam);

        return switch (sortType) {
            case AMOUNT -> repository.findAllByOrderByAmountDesc();
            case CATEGORY -> repository.findAllByOrderByCategoryAsc();
            case DATE -> repository.findAllByOrderByCreatedAtDesc();
        };
    }

    public void save(Expense expense) {
        repository.save(expense);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
