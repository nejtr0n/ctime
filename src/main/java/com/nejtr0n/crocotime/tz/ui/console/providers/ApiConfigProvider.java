package com.nejtr0n.crocotime.tz.ui.console.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.nejtr0n.crocotime.tz.persistence.api.ApiConfig;
import com.nejtr0n.crocotime.tz.persistence.api.CrocotimeApi;
import com.nejtr0n.crocotime.tz.ui.console.ConsoleTask;

public class ApiConfigProvider implements Provider<ApiConfig> {
    private ConsoleTask task;
    private String version;

    @Inject
    public ApiConfigProvider(ConsoleTask task, @CrocotimeApi.Version String version) {
        this.task = task;
        this.version = version;
    }

    public ApiConfig get() {
        return new ApiConfig(
            this.task.getHost(),
            this.task.getServerToken(),
            this.version
        );
    }
}
