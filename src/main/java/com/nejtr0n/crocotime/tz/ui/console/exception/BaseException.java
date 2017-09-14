package com.nejtr0n.crocotime.tz.ui.console.exception;

abstract public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }

    abstract public Integer getExitCode();
}

