package com.rastakiki.taki.expenses;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryExpenseRepository implements ExpenseRepository {

    private final Map<User, List<Expense>> expensesByUser = new HashMap<User, List<Expense>>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public List<Expense> findAllExpenses() {
        return ImmutableList.copyOf(Iterables.concat(expensesByUser.values()));
    }

    @Override
    public void delete(Expense expense) {

    }

    @Override
    public void save(Expense expense) {
        if (!expensesByUser.containsKey(expense.getUser())) {
            expensesByUser.put(expense.getUser(), new ArrayList<>());
        }
        expense.setId(idGenerator.getAndIncrement());
        expensesByUser.get(expense.getUser()).add(expense);
    }

    @Override
    public List<Expense> findExpensesByUser(User user) {
        final List<Expense> expenses = expensesByUser.get(user);
        if(expenses == null) {
            return ImmutableList.of();
        }
        return ImmutableList.copyOf(expenses);
    }

}
