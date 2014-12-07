package com.rastakiki.taki.expenses;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class ExpenseStepDefinitions {

    private final ExpenseRepository expenseRepository = new InMemoryExpenseRepository();

    @Given("^no expenses$")
    public void no_expenses() throws Throwable {
        final List<Expense> expenses = expenseRepository.findAllExpenses();
        for(Expense expense : expenses) {
            expenseRepository.delete(expense);
        }
    }

    @Given("^user \"(.*?)\"$")
    public void user(String user) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^user \"(.*?)\" logged in$")
    public void user_logged_in(String user) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^no expenses will be presented to the user \"(.*?)\"$\"")
    public void no_expenses_will_be_presented_to_the_user_User(String user) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
