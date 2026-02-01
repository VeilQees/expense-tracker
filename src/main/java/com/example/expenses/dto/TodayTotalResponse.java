package com.example.expenses.dto;

public class TodayTotalResponse {

    private double total;

    public TodayTotalResponse(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}
