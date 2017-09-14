package com.nejtr0n.crocotime.tz.ui.console;

import com.nejtr0n.crocotime.tz.application.AppContract;
import com.google.inject.Inject;
import com.nejtr0n.crocotime.tz.application.TaskContract;
import com.nejtr0n.crocotime.tz.domain.repository.TrackRepository;
import com.nejtr0n.crocotime.tz.ui.console.exception.ApiException;

public class App implements AppContract {
    public static final String EOL = System.getProperty("line.separator");

    private TaskContract task;
    private TrackRepository repository;

    @Inject
    public App(TaskContract task, TrackRepository repository) {
        this.task = task;
        this.repository = repository;
    }

    public void run() {
        try {
            System.out.println(
                "Created tracks " + task.execute(this.repository)
            );
        } catch (ApiException e) {
            System.out.println(e.getMessage());
            System.exit(e.getExitCode());
        }
    }
}
