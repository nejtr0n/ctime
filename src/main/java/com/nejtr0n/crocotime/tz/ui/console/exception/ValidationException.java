package com.nejtr0n.crocotime.tz.ui.console.exception;

public class ValidationException extends BaseException {
    public ValidationException(String message) {
        super(message);
    }

    public Integer getExitCode() {
        return -2;
    }
}
