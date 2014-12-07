package com.rastakiki.taki.expenses;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class TestApplication {

    @Bean
    public ExpenseRepository expenseRepository() {
        return new InMemoryExpenseRepository();
    }

}
