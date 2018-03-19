package com.example.Asus.shixun.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.Asus.shixun.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_wifi,tv_bluetooth,tv_net,tv_voice,tv_cunchu,tv_kaifa,tv_tongbu,tv_time,tv_set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    private void initview() {
        setContentView(R.layout.activity_setting);
        tv_wifi = findViewById(R.id.tv_wifi);
        tv_bluetooth = findViewById(R.id.tv_bluetooth);
        tv_net = findViewById(R.id.tv_net);
        tv_voice = findViewById(R.id.tv_voice);
        tv_cunchu = findViewById(R.id.tv_cunchu);
        tv_kaifa = findViewById(R.id.tv_kaifa);
        tv_tongbu = findViewById(R.id.tv_tongbu);
        tv_set = findViewById(R.id.tv_set);
        tv_time = findViewById(R.id.tv_time);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_wifi: {
                Intent intent = new Intent(Settings.ACTION_WIFI_IP_SETTINGS);
                startActivity(intent);
            }break;
            case R.id.tv_bluetooth: {
                Intent intent =  new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent);
            }break;
            case R.id.tv_net: {
                Intent intent =  new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
                startActivity(intent);
            }break;
            case R.id.tv_voice: {
                Intent intent =  new Intent(Settings.ACTION_SOUND_SETTINGS);
                startActivity(intent);
            }break;
            case R.id.tv_cunchu: {
                Intent intent =  new Intent(Settings.ACTION_MEMORY_CARD_SETTINGS);
                startActivity(intent);
            }break;
            case R.id.tv_kaifa: {
                Intent intent =  new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(intent);
            }break;
            case R.id.tv_tongbu: {
                Intent intent =  new Intent(Settings.ACTION_SYNC_SETTINGS);
                startActivity(intent);
            }break;
            case R.id.tv_time: {
                Intent intent =  new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
                startActivity(intent);
            }break;
            case R.id.tv_set: {
                Intent intent =  new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);

            }break;
        }
    }
}
