package com.winding.easyhttptest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.winding.easyhttptest.R;
import com.winding.easyhttptest.manage.DialogManage;

/**
 * Created by 刘少帅 on 2017/9/26
 */

public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        //DialogManage.getInstance().show(this,"玩命加载中....");
        DialogManage.getInstance().showLoading(this);
    }

    public void showProgressDialog(View view) {
        DialogManage.getInstance().show(this,"显示一下....");
    }

    public void dimiProgressDialog(View view) {
        DialogManage.getInstance().dimiss();
    }
}
