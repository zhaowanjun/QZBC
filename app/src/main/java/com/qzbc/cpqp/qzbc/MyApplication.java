package com.qzbc.cpqp.qzbc;

import android.app.Application;
import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2018/4/27.
 */
public class MyApplication extends Application {
    private static Context context;
    private final String BASE_URL = "http://192.168.1.86/";
    private static Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        //获取Context
        context = getApplicationContext();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //返回Context
    public static Context getContext(){
        return context;
    }

    public static Retrofit getRetrofit() {
        return mRetrofit;
    }
}
