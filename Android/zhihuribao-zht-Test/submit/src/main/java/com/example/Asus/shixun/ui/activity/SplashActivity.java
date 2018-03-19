package com.example.Asus.shixun.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Asus.shixun.R;

/*
* 闪屏界面
* */

public class SplashActivity extends Activity {

    private static final int SPLASH_DISPLAY_LENGTH = 3000;
    private Handler handler;

    private ImageView mImageViewBg;
    private TextView mTvWelcomeAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        initview();
        /*mImageViewBg.animate().scaleX(1.2f).scaleY(1.2f).setDuration(3000)
                .setStartDelay(100).start();*/
        mImageViewBg.animate().scaleX(1.2f).scaleY(1.2f).alpha(0).setDuration(4000)
                .start();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_in);
            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    //加载布局
    private void initview() {
        setContentView(R.layout.activity_splash);
        mImageViewBg = findViewById(R.id.iv_welcome_bg);
        mTvWelcomeAuthor = findViewById(R.id.tv_welcome_author);

    }
}
