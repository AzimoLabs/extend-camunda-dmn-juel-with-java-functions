package com.azimolabs.camunda.config;

import com.azimolabs.camunda.service.transaction.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfiguration {

    @Bean("transactionService")
    public TransactionService transactionService() {
        return new TransactionService();
    }

}