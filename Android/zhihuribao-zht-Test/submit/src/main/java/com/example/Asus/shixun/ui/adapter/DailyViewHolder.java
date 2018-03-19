package com.example.Asus.shixun.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Asus.shixun.R;

/**
 * Created by Lenovo on 2018/1/12.
 */

//重写ViewHolder方法
class DailyViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitle;
    ImageView ivImage;

    public DailyViewHolder(View itemView){
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_daily_item_title);
        ivImage = itemView.findViewById(R.id.iv_daily_item_image);
    }
}
