package com.nejtr0n.crocotime.tz.ui.console;

import com.google.inject.Provider;
import com.nejtr0n.crocotime.tz.ui.console.exception.BaseException;

public abstract class ConsoleProvider<T, E extends BaseException> implements Provider<T> {

    public abstract T getValidated() throws E;

    public T get() {
        try {
            return getValidated();
        } catch (BaseException e) {
            System.out.println(e.getMessage());
            System.exit(e.getExitCode());
            return null;
        }
    }
}
