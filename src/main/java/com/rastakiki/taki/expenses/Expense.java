package com.rastakiki.taki.expenses;

import java.util.Date;

public class Expense {

    private long id;
    private final User user;
    private final double amount;
    private final Date date;

    public Expense(User user, double amount, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }
}
