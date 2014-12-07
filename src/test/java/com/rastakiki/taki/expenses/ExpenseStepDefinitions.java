package com.rastakiki.taki.expenses;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ExpenseStepDefinitions {

    private final PresentExpenseUseCase presentExpenseUseCase;
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseStepDefinitions() {
        final ApplicationContext context = SpringApplication.run(TestApplication.class);
        expenseRepository = context.getBean(ExpenseRepository.class);
        userRepository = context.getBean(UserRepository.class);
        presentExpenseUseCase = context.getBean(PresentExpenseUseCase.class);
    }

    @Given("^no expenses$")
    public void no_expenses() throws Throwable {
        final List<Expense> expenses = expenseRepository.findAllExpenses();
        for(Expense expense : expenses) {
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
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^no expenses will be presented to the user \"(.*?)\"$\"")
    public void no_expenses_will_be_presented_to_the_user_User(String userName) throws Throwable {
        final List<PresentableExpense> presentableExpenses = presentExpenseUseCase.getPresentableExpenses(userName);
    }

}
