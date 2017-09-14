package com.nejtr0n.crocotime.tz.persistence.api;

import com.google.inject.BindingAnnotation;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface CrocotimeApi {
    @Headers( "Content-Type: application/json;charset=utf-8" )
    @POST("./")
    Call<ApiResponse> saveTrack(@Body RequestBody request);

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @BindingAnnotation
    public @interface Version {}
}
