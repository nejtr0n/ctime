package com.nejtr0n.crocotime.tz.ui.console.exception;

public class ApiException extends BaseException {
    public ApiException(String message) {
        super(message);
    }

    @Override
    public Integer getExitCode() {
        return -3;
    }
}
