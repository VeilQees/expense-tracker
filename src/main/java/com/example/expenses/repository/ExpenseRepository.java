package com.example.expenses.repository;

import com.example.expenses.dto.MonthlyTotalDto;
import com.example.expenses.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByOrderByCreatedAtDesc();

    List<Expense> findAllByOrderByAmountDesc();

    List<Expense> findAllByOrderByCategoryAsc();

    @Query("""
        SELECT new com.example.expenses.dto.MonthlyTotalDto(
            YEAR(e.createdAt),
            MONTH(e.createdAt),
            SUM(e.amount)
        )
        FROM Expense e
        GROUP BY YEAR(e.createdAt), MONTH(e.createdAt)
        ORDER BY YEAR(e.createdAt), MONTH(e.createdAt)
    """)
    List<MonthlyTotalDto> monthlyTotals();
}
