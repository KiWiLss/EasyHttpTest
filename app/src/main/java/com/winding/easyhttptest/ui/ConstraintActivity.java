package com.winding.easyhttptest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.winding.easyhttptest.R;

/**
 * Created by 刘少帅 on 2017/9/26
 */

public class ConstraintActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        /*
        1,app:layout_constraintLeft_toLeftOf="parent"
                让该控件的左侧与父布局对齐
        2, app:layout_constraintLeft_toLeftOf="@+id/tv2"
            当前属性的左侧在谁的左侧
        3,在constraint中,0代表的是match_constraint,类似于match_parent;
        4,app:layout_constraintDimensionRatio="H,16:6"
        该属性指的是宽高比,还可以这样写
         app:layout_constraintDimensionRatio="W,6:16"
        5,实现底部均分效果
        <TextView
    android:id="@+id/tab1"
    android:layout_width="0dp"
    android:layout_height="30dp"
    android:background="#f67"
    android:gravity="center"
    android:text="Tab1"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toLeftOf="@+id/tab2"
    app:layout_constraintHorizontal_weight="2"
    />
    <TextView
        android:id="@+id/tab2"
        android:layout_width="0dp"
        android:layout_height="30dp"
        android:background="#a67"
        android:gravity="center"
        android:text="Tab2"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toRightOf="@+id/tab1"
        app:layout_constraintRight_toLeftOf="@+id/tab3"
        app:layout_constraintHorizontal_weight="1"
        />
    <TextView
        android:id="@+id/tab3"
        android:layout_width="0dp"
        android:layout_height="30dp"
        android:background="#767"
        android:gravity="center"
        android:text="Tab3"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintLeft_toRightOf="@+id/tab2"
        app:layout_constraintHorizontal_weight="1"
        />
          app:layout_constraintHorizontal_weight="1"
          代表横向占有的比例,

          6, app:layout_constraintHorizontal_bias="0.901"
        app:layout_constraintVertical_bias="0.902"
        设置上下两侧间隙比例分别为90%和10%,控制两侧的拉力
        7,辅助线,在布局中不会显示,起辅助作用,帮助对齐
          <android.support.constraint.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent="0.8"/>

    <android.support.constraint.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.73"/>
         */




    }

}
