package com.rastakiki.taki.expenses;

import java.util.Date;

public class PresentableExpense {

    private final double amount;
    private final Date date;

    public PresentableExpense(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
