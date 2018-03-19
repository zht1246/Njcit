package com.example.Asus.shixun.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.Asus.shixun.R;
import com.example.Asus.shixun.ui.model.DailyListBean;
import com.example.Asus.shixun.ui.util.GlideImageLoade;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/1/12.
 */

public class DailyAadpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private DailyListBean dailyListBean;
    private Boolean isBefore = false;
    private Context context;
    private OnItemClickListener onItemClickListener;



    public enum ITEM_TYPE {
       ITEM_TOP, //滑动栏
        ITEM_DATE, //日期
        ITEM_CONTENT //内容
    }

    public DailyAadpter(DailyListBean dailyListBean,
                        Context context){
        this.dailyListBean = dailyListBean;
        this.context = context;

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


   @Override
    public int getItemViewType(int position){

       //return position;
        if (!isBefore){
            if (position == 0){
                return ITEM_TYPE.ITEM_TOP.ordinal();
            }
            else if (position ==1){
                return ITEM_TYPE.ITEM_DATE.ordinal();
            }
            else {
                return ITEM_TYPE.ITEM_CONTENT.ordinal();
            }
        }
        else {
            if (position == 0){
                return ITEM_TYPE.ITEM_DATE.ordinal();
            }
            else {
                return ITEM_TYPE.ITEM_CONTENT.ordinal();
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        if (viewType == ITEM_TYPE.ITEM_TOP.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_top,parent,false);
            Banner banner = view.findViewById(R.id.banner);
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            banner.setImageLoader(new GlideImageLoade());
            List<String> images = new ArrayList<>();
            List<String> titles = new ArrayList<>();

            for(int i = 0; i < 5; i++) {
                titles.add(dailyListBean.getTopStories().get(i).getTitle());
                images.add((dailyListBean.getTopStories().get(i).getImage()));
            }

            banner.setImages(images);
            banner.setBannerTitles(titles);
            banner.start();
            return new TopDailyViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily, parent, false);
            DailyViewHolder dailyViewHolder = new DailyViewHolder(view);
            view.setOnClickListener(this);
            return dailyViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof  DailyViewHolder) {
            final DailyViewHolder dvHolder = (DailyViewHolder) holder;
            dvHolder.tvTitle.setText(dailyListBean.getStories().get(position).getTitle());
            //Glide加载图片
            Glide.with(context).load(dailyListBean.getStories().get(position).getImages().get(0)).into(dvHolder.ivImage);
            dvHolder.ivImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dvHolder.itemView.setTag(position);
        }
    }

    //返回个数
    @Override
    public int getItemCount() {
        return dailyListBean.getStories().size();
    }

    //实现监听的接口
    public interface OnItemClickListener{
        void onItemClick(int position);
      /*  void onItemLongClick(int position);*/
    }

    //重写监听方法
    @Override
    public void onClick(View view) {
        if (onItemClickListener !=null){
            onItemClickListener.onItemClick((Integer) view.getTag());
        }
    }
}


