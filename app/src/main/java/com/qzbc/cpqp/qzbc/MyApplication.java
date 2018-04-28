package com.qzbc.cpqp.qzbc;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 2018/4/27.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //获取Context
        context = getApplicationContext();
    }

    //返回Context
    public static Context getContextObject(){
        return context;
    }
}
