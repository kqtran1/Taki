package com.rastakiki.taki.expenses;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class InMemoryExpenseRepository implements ExpenseRepository {

    private final List<Expense> expenses = new ArrayList<>();

    @Override
    public List<Expense> findAllExpenses() {
        return ImmutableList.copyOf(expenses);
    }

    @Override
    public void delete(Expense expense) {
        expenses.remove(expense);
    }

}
