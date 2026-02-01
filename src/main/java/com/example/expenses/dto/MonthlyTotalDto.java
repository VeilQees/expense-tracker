package com.example.expenses.dto;

import java.math.BigDecimal;

public record MonthlyTotalDto(
        Integer year,
        Integer month,
        BigDecimal total
) {}
