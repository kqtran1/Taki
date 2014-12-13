package com.rastakiki.taki.expenses;

public class Expense {

    private final User user;
    private double amount;

    public Expense(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }
}
