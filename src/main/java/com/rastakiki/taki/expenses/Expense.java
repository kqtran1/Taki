package com.rastakiki.taki.expenses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Expense {

    private long id;
    private final User user;
    private final double amount;
    private final LocalDate date;

    public Expense(User user, double amount, LocalDate date) {
        this.user = user;
        this.amount = amount;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }
}
