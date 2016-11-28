package com.example.administrator.myeasyshop;

import android.app.Application;

import com.example.administrator.myeasyshop.model.CachePreferences;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class EasyShopApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化ImageLoader
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//开启内存缓存
                .cacheOnDisk(true)//开启硬盘缓存
                .resetViewBeforeLoading(true)//再imageView加载前清除它之前的图片
                .build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSize(4 * 1024 * 1024)//设置内存缓存的大小（4M）
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader.getInstance().init(configuration);


        //初始化本地配置
        CachePreferences.init(this);
    }
}
