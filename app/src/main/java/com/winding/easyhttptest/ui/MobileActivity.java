package com.winding.easyhttptest.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;

import com.winding.easyhttptest.R;

import java.lang.reflect.Method;

/**
 * Created by 刘少帅 on 2017/9/29
 */

public class MobileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);


    }

    public void autoMobile(View view) {
        try {

            // 开始直接拨打电话
            Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "18657194104"));
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(intent2);
            Toast.makeText(MobileActivity.this, "拨打电话！", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    try {
                        // 延迟5秒后自动挂断电话
                        // 首先拿到TelephonyManager
                        TelephonyManager telMag = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                        Class<TelephonyManager> c = TelephonyManager.class;

                        // 再去反射TelephonyManager里面的私有方法 getITelephony 得到 ITelephony对象
                        Method mthEndCall = c.getDeclaredMethod("getITelephony", (Class[]) null);
                        //允许访问私有方法
                        mthEndCall.setAccessible(true);
                        final Object obj = mthEndCall.invoke(telMag, (Object[]) null);

                        // 再通过ITelephony对象去反射里面的endCall方法，挂断电话
                        Method mt = obj.getClass().getMethod("endCall");
                        //允许访问私有方法
                        mt.setAccessible(true);
                        mt.invoke(obj);
                        Toast.makeText(MobileActivity.this, "挂断电话！", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 10 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
