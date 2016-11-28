package com.example.administrator.myeasyshop.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myeasyshop.R;
import com.example.administrator.myeasyshop.commons.ActivityUtils;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private ActivityUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        utils = new ActivityUtils(this);

        // TODO: 2016/11/17 0017 登录账号冲突
        // TODO: 2016/11/17 0017 判断用户是否登录 

        Timer timer = new Timer();
        //1.5秒后跳转到主页面并且finish



        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                utils.startActivity(MainActivity.class);

                        if(isFirstRun())
                        {
                            utils.startActivity(GuideActivity.class);
                        }
                        else{
                            utils.startActivity(MainActivity.class);
                        }
                        //设置Activity的跳转动画
                        overridePendingTransition(R.anim.activity_enter,R.anim.activity_exit);
                        finish();
            }
        },1500);
    }
    /**
     * 判断应用是否是第一次运行
     * @return
     */
    private boolean isFirstRun() {
        SharedPreferences preferences=getSharedPreferences("app",MODE_PRIVATE);
        boolean isFirst=preferences.getBoolean("first_run",true);
        if(isFirst)
            preferences.edit().putBoolean("first_run",false).commit();
        return isFirst;
    }
}
