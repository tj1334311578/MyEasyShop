package com.example.administrator.myeasyshop.user.login;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2016/11/23 0023.
 */

public interface LoginView extends MvpView {

    void showPrb();

    void hidePrb();

    void loginFailed();

    void loginSuccess();

    void showMsg(String msg);
}
