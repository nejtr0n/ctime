package com.nejtr0n.crocotime.tz.persistence.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("result")
    @Expose
    private ResponseResult result;

    @SerializedName("error")
    @Expose
    private ResponseError error;

    public ResponseResult getResult() {
        return result;
    }

    public void setResult(ResponseResult result) {
        this.result = result;
    }

    public ResponseError getError() {
        return error;
    }

    public void setError(ResponseError error) {
        this.error = error;
    }

}
