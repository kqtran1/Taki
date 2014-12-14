package com.rastakiki.taki.expenses;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class PresentExpenseUseCaseTest {

    @Test
    public void user_canViewItsExpensesOrderByDescDateOrder() {
        final ExpenseRepository expenseRepository = new InMemoryExpenseRepository();
        final UserRepository userRepository = new InMemoryUserRepository();
        final PresentExpenseUseCase userCase = new PresentExpenseUseCase(expenseRepository, userRepository);
        final User user = new User("User");
        final Expense expense1 = new Expense(user, 20d, LocalDate.of(2014, Month.JANUARY, 10));
        final Expense expense2 = new Expense(user, 10d, LocalDate.of(2014, Month.AUGUST, 12));
        expenseRepository.save(expense1);
        expenseRepository.save(expense2);

        final List<PresentableExpense> presentableExpenses = userCase.getPresentableExpenses(user);

        assertThat(presentableExpenses).hasSize(2);
        assertThat(presentableExpenses).extracting("amount").containsExactly(10d, 20d);
        assertThat(presentableExpenses).extracting("date")
                .containsExactly(LocalDate.of(2014, Month.AUGUST, 12), LocalDate.of(2014, Month.JANUARY, 10));
    }

}