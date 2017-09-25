package com.winding.easyhttptest;

import android.app.Application;

import com.zhouyou.http.EasyHttp;

/**
 * Created by 刘少帅 on 2017/9/25
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EasyHttp.init(this);
    }
}
