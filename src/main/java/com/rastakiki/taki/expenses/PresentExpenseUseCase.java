package com.rastakiki.taki.expenses;

import java.util.List;
import java.util.stream.Collectors;

public class PresentExpenseUseCase {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public PresentExpenseUseCase(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public List<PresentableExpense> getPresentableExpenses(User user) {
        final List<Expense> expenses = expenseRepository.findExpensesByUser(user);
        return expenses.stream().map(e -> new PresentableExpense(e.getAmount())).collect(Collectors.toList());
    }
}
