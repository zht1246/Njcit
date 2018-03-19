package com.example.Asus.shixun.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.Asus.shixun.R;

/*
* 登录界面
* */
public class LoginActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button bt_regiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    private void initview() {
        setContentView(R.layout.activity_login);
        bt_regiter=findViewById(R.id.submit);



    }




}
