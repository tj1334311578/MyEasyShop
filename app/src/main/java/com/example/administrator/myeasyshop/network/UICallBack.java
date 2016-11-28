package com.example.administrator.myeasyshop.network;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/18 0018.
 */

public abstract class UICallBack implements Callback {

    //拿到主线程的handler
    private final Handler handler = new Handler(Looper.getMainLooper());

    //ctrl+o....实现方法
    @Override
    public void onFailure(final Call call, final IOException e) {
        //通过主线程handler.post方法做一个再主线程中运行的run方法
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailureUI(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {
        //判断成功的情况
        if (!response.isSuccessful()) {
            throw new IOException("error code:" + response.code());
        }

        //拿到json字符串
        final String json = response.body().string();

        handler.post(new Runnable() {
            @Override
            public void run() {
                onResponseUI(call, json);
            }
        });
    }

    public abstract void onFailureUI(Call call, IOException e);

    public abstract void onResponseUI(Call call, String body);


}
