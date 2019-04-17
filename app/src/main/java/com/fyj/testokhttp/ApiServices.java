package com.fyj.testokhttp;

import com.google.gson.JsonObject;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiServices {
    @GET("3/discover/movie")
    Flowable <JsonObject> getMoviesInfo(@QueryMap HashMap<String,String> params);
}
