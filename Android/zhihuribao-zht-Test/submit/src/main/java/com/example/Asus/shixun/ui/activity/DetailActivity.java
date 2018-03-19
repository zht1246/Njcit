package com.example.Asus.shixun.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.Asus.shixun.R;
import com.example.Asus.shixun.ui.model.DetailBean;
import com.example.Asus.shixun.ui.util.HtmlUtil;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Lenovo on 2018/1/17.
 */

public class DetailActivity extends AppCompatActivity {

    private TextView mTv;
    private ImageView mIv;
    private WebView mWb;
    private DetailBean detailBean;
    private int id;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initview();

        Toolbar toolbar = (Toolbar)findViewById(R.id.iew_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id = getIntent().getIntExtra("id",9666020);
        detailBean = parseJSON(id);
        String htmlData = HtmlUtil.createHtmlData(detailBean.getBody(),detailBean.getCss(),detailBean.getJs());
        mTv.setText(detailBean.getImageSource());
        Glide.with(this).load(detailBean.getImage()).into(mIv);
        mWb.loadData(htmlData,HtmlUtil.MIME_TYPE,HtmlUtil.ENCODING);
    }

    private void initview() {
        setContentView(R.layout.activity_detail);
        mTv = findViewById(R.id.tv_text);
        mIv = findViewById(R.id.iv_detail_bar_image);
        mWb = findViewById(R.id.wv_body);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_detail, menu);
        return true;
    }

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/



    public DetailBean parseJSON(int id){

        DetailBean detailBean = null;
        try {
            InputStream inputStream = getAssets().open(id+".json");
            int size = inputStream.available();
            byte[] buf = new byte[size];
            inputStream.read(buf);
            String text = new String(buf,"UTF-8");

            //JSON解析数据
            detailBean = JSON.parseObject(text, DetailBean.class);

            Log.i("text","123");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  detailBean;
    }

}
