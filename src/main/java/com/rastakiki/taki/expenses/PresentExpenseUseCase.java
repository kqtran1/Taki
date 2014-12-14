package com.rastakiki.taki.expenses;

import java.util.List;
import java.util.stream.Collectors;

public class PresentExpenseUseCase {

    private final ExpenseRepository expenseRepository;

    public PresentExpenseUseCase(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<PresentableExpense> getPresentableExpenses(User user) {
        final List<Expense> expenses = expenseRepository.findExpensesByUser(user);
        return expenses.stream()
                .map(e -> new PresentableExpense(e.getAmount(), e.getDate()))
                .sorted((e1, e2) -> e2.getDate().compareTo(e1.getDate()))
                .collect(Collectors.toList());
    }

}
