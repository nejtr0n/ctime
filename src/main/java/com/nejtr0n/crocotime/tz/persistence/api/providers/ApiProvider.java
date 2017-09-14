package com.nejtr0n.crocotime.tz.persistence.api.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.nejtr0n.crocotime.tz.persistence.api.ApiConfig;
import com.nejtr0n.crocotime.tz.persistence.api.CrocotimeApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider implements Provider<CrocotimeApi> {
    private ApiConfig config;

    @Inject
    public ApiProvider(ApiConfig config) {
        this.config = config;
    }
    public CrocotimeApi get() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this.config.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CrocotimeApi.class);
    }
}
