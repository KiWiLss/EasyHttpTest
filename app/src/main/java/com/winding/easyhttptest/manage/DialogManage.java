package com.winding.easyhttptest.manage;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;

import com.winding.easyhttptest.R;

/**
 * Created by 刘少帅 on 2017/9/26
 */

public class DialogManage {

    private static final String TAG = "MMM";
    private static volatile DialogManage instance;
    private ProgressDialog mPd;

    public static DialogManage getInstance(){
        if (instance==null){
            synchronized (DialogManage.class){
                if (instance==null) {
                    instance=new DialogManage();
                }
            }
        }
        return instance;
    }

    public void show(Context context,String msg){
        mPd = new ProgressDialog(context);
        if (!TextUtils.isEmpty(msg)){
            mPd.setMessage(msg);
        }
        mPd.setTitle("提示");
        mPd.show();
    }

    public void showLoading(Context context){
        Dialog dialog = new Dialog(context, R.style.dialog_custom);
        dialog.setContentView(R.layout.dialog_custom);
        //dialog.setCancelable(false);
        dialog.show();
    }

    public void dimiss(){
        if (mPd!=null){
            mPd.dismiss();
        }
    }


}
