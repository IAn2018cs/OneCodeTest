package cn.ian2018.onecodetest;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/1/21/021.
 */

public class MyApplication extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
