package com.nejtr0n.crocotime.tz.ui.console.exception;

public class JsonFileNotFoundedException extends BaseException {
    public JsonFileNotFoundedException(String message) {
        super(message);
    }

    public Integer getExitCode() {
        return -3;
    }
}
