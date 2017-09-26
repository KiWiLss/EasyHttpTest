package com.winding.easyhttptest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kiwi.library.PopupOneUtils;
import com.kiwi.library.PopupOneUtils2;
import com.winding.easyhttptest.R;
import com.winding.easyhttptest.manage.DialogManage;

/**
 * Created by 刘少帅 on 2017/9/26
 */

public class DialogActivity extends AppCompatActivity {
    private static final int cangliang = 850;
    private static final String KEY_ = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        //DialogManage.getInstance().show(this,"玩命加载中....");
        DialogManage.getInstance().showLoading(this);






    }

    public void showProgressDialog(View view) {

        new PopupOneUtils2(this, new PopupOneUtils2.ContentClickListener() {
            @Override
            public void sureClickListener(PopupOneUtils2 popupOneUtils2) {
                popupOneUtils2.dismiss();
            }

            @Override
            public void cancelClickListener() {

            }
        }).setTitleAndColor("小小试试",0,true)
                .showCenter(this);

    }



    public void dimissProgressDialog(View view) {
        new PopupOneUtils(this, new PopupOneUtils.ContentClickListener() {
            @Override
            public void sureClickListener(PopupOneUtils popupOneUtils) {

            }

            @Override
            public void cancelClickListener() {

            }
        }).setTitleAndColor("hellokitty",0,true)
                .setRadius(2)
                .showCenter(this);
    }
}
