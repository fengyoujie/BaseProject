package com.fyj.testokhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {
    private String mBaseUrl = "http://api.themoviedb.org/" ;
    private static volatile RetrofitProvider mInstance ;
    private OkHttpClient mClient ;
    private Retrofit mRetrofit ;
    private ApiServices mApiServices ;
    private RetrofitProvider(){}

    public static RetrofitProvider getInstance(){
        if(mInstance == null){
            synchronized (RetrofitProvider.class){
                if(mInstance == null){
                    mInstance = new RetrofitProvider();
                }
            }
        }
        return mInstance ;
    }

    public synchronized ApiServices getApiServices(){
        if(mRetrofit == null){
            mRetrofit = getRetrofit() ;
        }
        if(mApiServices == null){
            mApiServices = mRetrofit.create(ApiServices.class) ;
        }
        return mApiServices ;
    }

    private OkHttpClient getOkHttpClient(){
        if(mClient ==null){
            mClient = new OkHttpClient.Builder()
                    .connectTimeout(3000, TimeUnit.MILLISECONDS)
                    .readTimeout(3000,TimeUnit.MILLISECONDS)
                    .writeTimeout(3000,TimeUnit.MILLISECONDS)
                    .build();
        }
        return mClient;
    }

    private synchronized Retrofit getRetrofit(){
        if(mClient == null){
           mClient = getOkHttpClient() ;
        }

        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(mBaseUrl)
                    .client(mClient)
                    //.addConverterFactory(new ToStringConverFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return mRetrofit ;
    }
}
