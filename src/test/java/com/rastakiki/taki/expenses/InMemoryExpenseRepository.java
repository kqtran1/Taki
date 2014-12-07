package com.rastakiki.taki.expenses;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryExpenseRepository implements ExpenseRepository {

    private final List<Expense> expenses = new ArrayList<Expense>();
    private final Map<User, List<Expense>> expensesByUser = new HashMap<User, List<Expense>>();

    @Override
    public List<Expense> findAllExpenses() {
        return ImmutableList.copyOf(expenses);
    }

    @Override
    public void delete(Expense expense) {
        expenses.remove(expense);
    }

    @Override
    public void findExpensesForUser(User user) {

    }

}
