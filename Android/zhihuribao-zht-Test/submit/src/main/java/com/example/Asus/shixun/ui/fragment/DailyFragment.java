package com.example.Asus.shixun.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.Asus.shixun.R;
import com.example.Asus.shixun.ui.activity.DetailActivity;
import com.example.Asus.shixun.ui.adapter.DailyAadpter;
import com.example.Asus.shixun.ui.model.DailyListBean;
import com.youth.banner.Banner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/1/11.
 */

public class DailyFragment extends Fragment implements DailyAadpter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private DailyListBean dailyListBean;
    private DailyAadpter dailyAadpter;
    Banner mBanner;
    private List<String> images = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public DailyFragment(){

    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        /*for (int i =0; i<100;i++){
            items.add("新闻"+i);
        }*/
        View view = inflater.inflate(R.layout.fragment_daily,container,false);

        parseJSON();

        dailyAadpter = new DailyAadpter(dailyListBean,getContext());

        dailyAadpter.setOnItemClickListener(this);

        mRecyclerView = view.findViewById(R.id.rv_daily_items);
        mRecyclerView.setAdapter(dailyAadpter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        /*dailyAadpter.setOnItemClickListener(new DailyAadpter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0: {
                        Intent intent = new Intent();
                        intent.setClass(getActivity(), DetailActivity.class);
                        startActivity(intent);
                    }
                    case 1:{

                    }
                    case 2:{

                    }
                    case 3:{

                    }
                }
            }
*/
          /*  @Override
            public void onItemLongClick(View view, int position) {

            }
        });*/
       /* mBanner = view.findViewById(R.id.banner);

        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);

        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoade());
        images.add("file:///android_assert/a.jpg");
        images.add("file:///android_assert/a1.jpg");
        images.add("file:///android_assert/a1.jpg");
        titles.add("1");
        titles.add("2");
        titles.add("3");
        //设置图片集合
        mBanner.setImages(images);
        //设置标题集合（当mbanner样式有显示title时）
        mBanner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（mbanner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //mbanner设置方法全部调用完毕时最后调用
        mBanner.start();*/
        return view;
    }

    public void parseJSON(){
        try {
            InputStream inputStream = getContext().getAssets().open("news.json");
            int size = inputStream.available();
            byte[] buf = new byte[size];
            inputStream.read(buf);
            String text = new String(buf,"UTF-8");

            //JSON解析数据
            dailyListBean = JSON.parseObject(text, DailyListBean.class);

            Log.i("text","123");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        DailyListBean.StoriesBean storiesBean = dailyListBean.getStories().get(position);
        intent.putExtra("id",storiesBean.getId());
        startActivity(intent);
    }

  /*  @Override
    public void onItemLongClick(int position) {

    }*/
}
