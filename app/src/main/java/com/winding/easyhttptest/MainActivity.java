package com.winding.easyhttptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.winding.easyhttptest.model.AppBack;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    public  final String BASE_URL = "http://app.zhongjianmall.com/api/UserInterface/";

    public  String APP_CFG="http://app.zhongjianmall.com/api/UserInterface/GetAppConfig?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EasyHttp.get("GetAppConfig?")
                .readTimeOut(30 * 1000)//局部定义读超时
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)
                //.params("name","张三")
                .timeStamp(true)
                .baseUrl(BASE_URL)
                .execute(new SimpleCallBack<AppBack>() {

                    @Override
                    public void onError(ApiException e) {
                        Log.i(TAG, "onError: "+e.getMessage().toString());
                    }

                    @Override
                    public void onSuccess(AppBack appBack) {
                        Log.i(TAG, "onSuccess: "+appBack.toString());
                    }
                });

    }
}
