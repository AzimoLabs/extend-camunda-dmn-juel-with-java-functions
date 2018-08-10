package com.azimolabs.camunda.service.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public Integer getSuccessfulTransactionCount(Integer userId) {
        LOGGER.info("Get successful transaction count for user with id '{}'", userId);

        int count = 0;

        // ...

        // Business logic implementation

        // ...

        return count;
    }

}
