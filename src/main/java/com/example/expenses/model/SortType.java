package com.example.expenses.model;

public enum SortType {
    DATE,
    AMOUNT,
    CATEGORY;

    public static SortType from(String value) {
        if (value == null || value.isBlank()) {
            return DATE;
        }

        try {
            return SortType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return DATE;
        }
    }
}
