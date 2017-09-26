package com.winding.easyhttptest;

import android.app.Application;

import com.kingja.loadsir.core.LoadSir;
import com.winding.easyhttptest.callback.CustomCallback;
import com.winding.easyhttptest.callback.EmptyCallback;
import com.winding.easyhttptest.callback.ErrorCallback;
import com.winding.easyhttptest.callback.LoadingCallback;
import com.winding.easyhttptest.callback.TimeoutCallback;


/**
 * Created by 刘少帅 on 2017/9/25
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())//添加各种状态页
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)//设置默认状态页
                .commit();
    }
}
