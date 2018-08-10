package com.azimolabs.camunda.exception;

public class FunctionRegistrationFailedException extends RuntimeException {

    private final static String message = "Could not register function";

    public FunctionRegistrationFailedException(Throwable cause) {
        super(message, cause);
    }
}
