package com.nejtr0n.crocotime.tz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nejtr0n.crocotime.tz.application.Container;
import com.nejtr0n.crocotime.tz.application.AppContract;
import com.nejtr0n.crocotime.tz.ui.console.Args;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        Args config = new Args(Arrays.asList(args));
        Injector injector = Guice.createInjector(new Container(config));
        injector.getInstance(AppContract.class).run();
    }
}
