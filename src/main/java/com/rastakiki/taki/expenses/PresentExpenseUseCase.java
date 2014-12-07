package com.rastakiki.taki.expenses;

import java.util.List;

public class PresentExpenseUseCase {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public PresentExpenseUseCase(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public List<PresentableExpense> getPresentableExpenses(String userName) {
        final User user = userRepository.findUserByName(userName);
        expenseRepository.findExpensesForUser(user);
        return null;
    }

}
