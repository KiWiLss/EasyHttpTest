package com.winding.easyhttptest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.winding.easyhttptest.R;
import com.winding.easyhttptest.adapter.MianAdapter;

import java.util.ArrayList;

/**
 * Created by 刘少帅 on 2017/9/26
 */

public class TestRecyclerActivity extends AppCompatActivity {

    private ShimmerRecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler);

        rv = (ShimmerRecyclerView) findViewById(R.id.shimmer_recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> mData = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mData.add("jk");
        }
        MianAdapter adapter = new MianAdapter(this, mData);
        rv.setAdapter(adapter);

    }
}
