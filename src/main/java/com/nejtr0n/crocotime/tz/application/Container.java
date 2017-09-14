package com.nejtr0n.crocotime.tz.application;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.nejtr0n.crocotime.tz.domain.repository.TrackRepository;
import com.nejtr0n.crocotime.tz.persistence.api.ApiConfig;
import com.nejtr0n.crocotime.tz.persistence.api.CrocotimeApi;
import com.nejtr0n.crocotime.tz.persistence.api.providers.ApiProvider;
import com.nejtr0n.crocotime.tz.persistence.api.repository.ApiTrackRepository;
import com.nejtr0n.crocotime.tz.ui.console.*;
import com.nejtr0n.crocotime.tz.ui.console.providers.ApiConfigProvider;
import com.nejtr0n.crocotime.tz.ui.console.providers.ArgsProvider;
import com.nejtr0n.crocotime.tz.ui.console.providers.TaskProvider;

/**
 * Ioc container
 */
public class Container extends AbstractModule {
    private final Args args;

    public Container(Args args) {
        this.args = args;
    }

    protected void configure() {
        bind(AppContract.class).to(App.class).in(Singleton.class);
        bindConstant().annotatedWith(CrocotimeApi.Version.class).to("5.7.3");
        bind(Args.class).toProvider(new ArgsProvider(this.args));
        bind(TaskContract.class).to(ConsoleTask.class);
        bind(ConsoleTask.class).toProvider(TaskProvider.class);
        bind(ApiConfig.class).toProvider(ApiConfigProvider.class);
        bind(CrocotimeApi.class).toProvider(ApiProvider.class);
        bind(TrackRepository.class).to(ApiTrackRepository.class);
    }
}
