package com.nejtr0n.crocotime.tz.ui.console;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nejtr0n.crocotime.tz.application.Task;

public class ConsoleTask extends Task {
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("server_token")
    @Expose
    private String serverToken;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getServerToken() {
        return serverToken;
    }

    public void setServerToken(String serverToken) {
        this.serverToken = serverToken;
    }
}
