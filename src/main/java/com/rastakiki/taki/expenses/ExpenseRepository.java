package com.rastakiki.taki.expenses;

import java.util.List;

public interface ExpenseRepository {

    List<Expense> findAllExpenses();

    void delete(Expense expense);

    void save(Expense expense);

    List<Expense> findExpensesByUser(User user);

}
