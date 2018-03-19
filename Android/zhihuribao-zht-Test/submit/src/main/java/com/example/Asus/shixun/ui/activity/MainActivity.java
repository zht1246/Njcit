package com.example.Asus.shixun.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.Asus.shixun.R;
import com.example.Asus.shixun.ui.adapter.BaibaiAdapter;
import com.example.Asus.shixun.ui.fragment.DailyFragment;
import com.example.Asus.shixun.ui.fragment.HotFragment;
import com.example.Asus.shixun.ui.fragment.SectionFragment;
import com.example.Asus.shixun.ui.fragment.ThemeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

/*    private ArrayList<String> titleList = new ArrayList<String>(){
        {
            add("日报");
            add("专栏");
            add("热点");
            add("主题");

        }};

    private ArrayList<Fragment> fragmentList = new  ArrayList<Fragment>(){
        {
            add(new DailyFragment());
            add(new HotFragment());
            add(new SectionFragment());
            add(new ThemeFragment());
        }};*/


  /*  private FragmentManager fm = getSupportFragmentManagergmentManager();
    FragmentTransaction fragment = fragmentm.beginTransaction();*/
  private TabLayout tl_main;
  private ViewPager vp_main;
  private String[] tabTitle = new String[] {"日报","专栏","热点","主题"};
  private List<Fragment> fragments = new ArrayList<Fragment>();
  private BaibaiAdapter baibaiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initview();
        initEventAndata();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //后退
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initview() {
        setContentView(R.layout.activity_main);
        tl_main = findViewById(R.id.tl_main);
        vp_main = findViewById(R.id.vp_main);
    }

    private void initEventAndata() {
        fragments.add(new DailyFragment());
        fragments.add(new HotFragment());
        fragments.add(new SectionFragment());
        fragments.add(new ThemeFragment());
        baibaiAdapter = new BaibaiAdapter(getSupportFragmentManager(),fragments);


        for (int  i = 0; i <tabTitle.length; i++){
            tl_main.addTab(tl_main.newTab().setText(tabTitle[i]));
        }
       /* tl_main.addTab(tl_main.newTab().setText(tabTitle[0]));
        tl_main.addTab(tl_main.newTab().setText(tabTitle[1]));
        tl_main.addTab(tl_main.newTab().setText(tabTitle[2]));
        tl_main.addTab(tl_main.newTab().setText(tabTitle[3]));*/

        vp_main.setAdapter(baibaiAdapter);
        tl_main.setupWithViewPager(vp_main);

        for (int  i = 0; i <tabTitle.length; i++){
            tl_main.getTabAt(i).setText(tabTitle[i]);
            tl_main.getTabAt(i).setIcon(R.mipmap.ic_launcher);
        }

       /* tl_main.getTabAt(0).setText(tabTitle[0]);
        tl_main.getTabAt(1).setText(tabTitle[1]);
        tl_main.getTabAt(2).setText(tabTitle[2]);
        tl_main.getTabAt(3).setText(tabTitle[3]);*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            showExitDialog();
        }
    }

    private  void showExitDialog(){
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.bibi);
        builder.setTitle("提示");
        builder.setMessage("确定要退出吗");
        builder.setNegativeButton("取消",null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        });
        AlertDialog dialog = builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_offerline) {
        }

        if (id == R.id.nav_person) {

            Intent intent = new Intent();
            intent.setClass(getApplicationContext(),PersonActivity.class);
            startActivity(intent);

        }

        if (id == R.id.nav_setting) {

            Intent intent = new Intent();
            intent.setClass(getApplicationContext(),SettingActivity.class);
            startActivity(intent);
        }

        if (id == R.id.nav_about) {
            Intent intent =new Intent(getApplicationContext(),AboutActivity.class);
            startActivity(intent);

        }

        if (id == R.id.nav_tuichu_login) {
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   /* public void showDetail(View view){
        Intent intent = new Intent(this,DetailActivity.class);
        startActivity(intent);
    }*/

}
