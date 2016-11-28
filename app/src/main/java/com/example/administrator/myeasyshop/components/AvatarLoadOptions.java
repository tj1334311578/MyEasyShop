package com.example.administrator.myeasyshop.components;

import com.example.administrator.myeasyshop.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;


public class AvatarLoadOptions {

    private AvatarLoadOptions() {
    }

    private static DisplayImageOptions options;

    /**
     * 用户头像加载选项
     */
    public static DisplayImageOptions build() {
        if (options == null) {
            options = new DisplayImageOptions.Builder()
                    .showImageForEmptyUri(R.mipmap.user_ico)/*如果空url显示什么*/
                    .showImageOnLoading(R.mipmap.user_ico)/*加载中显示什么*/
                    .showImageOnFail(R.mipmap.user_ico)/*加载失败显示什么*/
                    .cacheOnDisk(true)/*开启硬盘缓存*/
                    .cacheInMemory(true)/*开启内存缓存*/
                    .resetViewBeforeLoading(true)/*加载前重置ImageView*/
                    .build();
        }
        return options;
    }

    private static DisplayImageOptions options_item;

    /**
     * 图片加载选项
     */
    public static DisplayImageOptions build_item() {
        if (options_item == null) {
            options_item = new DisplayImageOptions.Builder()
                    .showImageForEmptyUri(R.mipmap.image_error)/*如果空url显示什么*/
                    .showImageOnLoading(R.mipmap.image_loding)/*加载中显示什么*/
                    .showImageOnFail(R.mipmap.image_error)/*加载失败显示什么*/
                    .cacheOnDisk(true)/*开启硬盘缓存*/
                    .cacheInMemory(true)/*开启内存缓存*/
                    .resetViewBeforeLoading(true)/*加载前重置ImageView*/
                    .build();
        }
        return options_item;
    }
}
