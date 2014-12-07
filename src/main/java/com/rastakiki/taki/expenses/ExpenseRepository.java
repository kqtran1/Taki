package com.rastakiki.taki.expenses;

import java.util.List;

public interface ExpenseRepository {

    List<Expense> findAllExpenses();

    void delete(Expense expense);

    void findExpensesForUser(User user);

}
