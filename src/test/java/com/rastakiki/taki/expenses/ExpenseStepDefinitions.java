package com.rastakiki.taki.expenses;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseStepDefinitions {

    private PresentExpenseUseCase presentExpenseUseCase;
    private ExpenseRepository expenseRepository;
    private UserRepository userRepository;

    @Before
    public void initUseCase() {
        expenseRepository = new InMemoryExpenseRepository();
        userRepository = new InMemoryUserRepository();
        presentExpenseUseCase = new PresentExpenseUseCase(expenseRepository, userRepository);

    }

    @Given("^no expenses$")
    public void no_expenses() throws Throwable {
        final List<Expense> expenses = expenseRepository.findAllExpenses();
        for (Expense expense : expenses) {
            expenseRepository.delete(expense);
        }
    }

    @Given("^user \"(.*?)\"$")
    public void user(String userName) throws Throwable {
        final User user = new User(userName);
        userRepository.save(user);
    }

    @When("^user \"(.*?)\" logged in$")
    public void user_logged_in(String userName) throws Throwable {
    }

    @Then("^no expenses will be presented to the user \"(.*?)\"$")
    public void no_expenses_will_be_presented_to_the_user(String userName) throws Throwable {
        final List<PresentableExpense> presentableExpenses = presentExpenseUseCase.getPresentableExpenses(userName);
        assertThat(presentableExpenses).isEmpty();
    }


}
