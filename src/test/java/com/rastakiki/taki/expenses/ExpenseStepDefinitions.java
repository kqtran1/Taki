package com.rastakiki.taki.expenses;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseStepDefinitions {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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
        final List<PresentableExpense> presentableExpenses = presentExpenseUseCase.getPresentableExpenses(new User(userName));
        assertThat(presentableExpenses).isEmpty();
    }

    @Given("^\"(.*?)\" user expenses$")
    public void user_expenses(String userName, DataTable expenses) throws Throwable {
        final User user = userRepository.findUserByName(userName);

        final List<List<String>> rowList = expenses.raw();
        for (int i = 1; i < rowList.size(); i++) {
            final List<String> row = rowList.get(i);
            final LocalDate date = LocalDate.parse(row.get(0), dateFormatter);
            final double amount = Double.valueOf(row.get(1));
            expenseRepository.save(new Expense(user, amount, date));
        }
    }

    @Then("^the following expenses will be presented to the user \"(.*?)\" in order$")
    public void the_following_expenses_will_be_presented_to_the_user_in_order(String userName, DataTable expectedExpenses) throws Throwable {
        final User user = userRepository.findUserByName(userName);
        final List<PresentableExpense> expenses = presentExpenseUseCase.getPresentableExpenses(user);


        final List<List<String>> rowList = expectedExpenses.raw();
        assertThat(expenses).hasSize(rowList.size() - 1);
        for (int i = 1; i < rowList.size(); i++) {
            final List<String> row = rowList.get(i);
            final LocalDate date = LocalDate.parse(row.get(0), dateFormatter);
            final double amount = Double.valueOf(row.get(1));
            final PresentableExpense currentExpense = expenses.get(i - 1);
            assertThat(currentExpense.getDate()).isEqualTo(date);
            assertThat(currentExpense.getAmount()).isEqualTo(amount);
        }
    }

}
