package com.example.expenses.model;

public enum Category {

    FOOD("Еда"),
    CLOTHES("Одежда"),
    TRANSPORT("Транспорт"),
    ENTERTAINMENT("Развлечения"),
    OTHER("Другое");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
