package com.winding.easyhttptest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winding.easyhttptest.R;

import java.util.List;

/**
 * Created by 刘少帅 on 2017/9/26
 */

public class MianAdapter extends RecyclerView.Adapter<MianAdapter.ViewHolder>{
    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<String>mData;

    public MianAdapter(Context mContext, List<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
