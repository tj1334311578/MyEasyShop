package com.example.administrator.myeasyshop.main.me.personInfo;

import com.example.administrator.myeasyshop.model.CachePreferences;
import com.example.administrator.myeasyshop.model.User;
import com.example.administrator.myeasyshop.model.UserResult;
import com.example.administrator.myeasyshop.network.EasyShopClient;
import com.example.administrator.myeasyshop.network.UICallBack;
import com.google.gson.Gson;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/23 0023.
 */

public class PersonPersenter extends MvpNullObjectBasePresenter<PersonView> {

    private Call call;

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (call != null) call.cancel();
    }

    //上传头像
    public void updataAvatar(File file){
        getView().showPrb();
        call = EasyShopClient.getInstance().uploadAvatar(file);
        call.enqueue(new UICallBack() {
            @Override
            public void onFailureUI(Call call, IOException e) {
                getView().hidePrb();
                getView().showMsg(e.getMessage());
            }

            @Override
            public void onResponseUI(Call call, String body) {
                getView().hidePrb();
                UserResult userResult = new Gson().fromJson(body,UserResult.class);
                if (userResult == null){
                    getView().showMsg("未知错误");
                }else if (userResult.getCode() != 1){
                    getView().showMsg(userResult.getMessage());
                    return;
                }

                User user = userResult.getData();
                CachePreferences.setUser(user);
                //调用activity里的头像更新方法，把url传过去
                getView().updataAvatar(userResult.getData().getHead_Image());

                // TODO: 2016/11/24 0024 环信更新用户头像
            }
        });
    }
}
