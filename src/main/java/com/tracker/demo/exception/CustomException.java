package com.tracker.demo.exception;

public class CustomException extends RuntimeException {
    private final int status;
    private final String errorCode;

    public CustomException(int status, String errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }
}