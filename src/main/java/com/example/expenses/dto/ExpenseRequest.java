package com.example.expenses.dto;

import com.example.expenses.model.Category;
import java.math.BigDecimal;

public class ExpenseRequest {

    private BigDecimal amount;
    private Category category;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
