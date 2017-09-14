package com.nejtr0n.crocotime.tz.persistence.api;

public class ApiConfig {
    private final String url;
    private final String token;
    private final String version;

    public ApiConfig(String url, String token, String version) {
        this.url = url;
        this.token = token;
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public String getToken() {
        return token;
    }

    public String getVersion() {
        return version;
    }
}
