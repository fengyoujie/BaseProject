package com.fyj.testokhttp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

public class BaseApp extends Application {
    private static BaseApp mBaseApp ;

    @Override
    public void onCreate(){
        super.onCreate();
        mBaseApp = this ;
    }

    public static Context getAppContext(){
        return mBaseApp ;
    }

    public static Resources getAppResource(){
        return mBaseApp.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }
}
