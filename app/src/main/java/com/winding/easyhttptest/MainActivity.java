package com.winding.easyhttptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kingja.loadsir.core.LoadService;
import com.winding.easyhttptest.model.TestModel;
import com.winding.easyhttptest.ui.ConstraintActivity;

public class MainActivity extends AppCompatActivity {



    public static final String TAG = "MMM";
    public  final String BASE_URL = "http://app.zhongjianmall.com/api/UserInterface/";

    public  String APP_CFG="http://app.zhongjianmall.com/api/UserInterface/GetAppConfig?";
    private LoadService mLoadService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        mLoadService = LoadSir.getDefault().register(this, new Callback.OnReloadListener() {
//            @Override
//            public void onReload(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mLoadService.showCallback(LoadingCallback.class);
//                        SystemClock.sleep(5000);
//                        mLoadService.showSuccess();
//                    }
//                }).start();
//            }
//        });
//
//        PostUtil.postCallbackDelayed(mLoadService, EmptyCallback.class);
    }

    public void toTestListener(View view) {
        TestModel testModel = new TestModel("name",90,"hello");
        Intent intent = new Intent(this, ConstraintActivity.class);
        intent.putExtra("object",testModel);

        startActivity(intent);
    }
}
