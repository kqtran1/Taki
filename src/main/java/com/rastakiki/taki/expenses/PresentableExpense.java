package com.rastakiki.taki.expenses;

import java.time.LocalDate;

public class PresentableExpense {

    private final double amount;
    private final LocalDate date;

    public PresentableExpense(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
