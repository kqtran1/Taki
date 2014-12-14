package com.rastakiki.taki.expenses;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class PresentExpenseUseCaseTest {

    @Test
    public void user_canViewItsExpenses() {
        final ExpenseRepository expenseRepository = new InMemoryExpenseRepository();
        final UserRepository userRepository = new InMemoryUserRepository();
        final PresentExpenseUseCase userCase = new PresentExpenseUseCase(expenseRepository, userRepository);
        final User user = new User("User");
        final Expense expense1 = new Expense(user, 10d, new Date());
        final Expense expense2 = new Expense(user, 20d, new Date());
        expenseRepository.save(expense1);
        expenseRepository.save(expense2);

        final List<PresentableExpense> presentableExpenses = userCase.getPresentableExpenses(user);

        assertThat(presentableExpenses).hasSize(2);
        assertThat(presentableExpenses).extracting("amount").contains(10d, 20d);
    }

}