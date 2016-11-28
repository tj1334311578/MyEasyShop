package com.example.administrator.myeasyshop.model;

import com.google.gson.annotations.SerializedName;

/**
 * //成功
 {
 "code": 1, //结果码
 "msg": "succeed",
 "data": {
 "name": "ytd70aa402693e4333a6318933226d0276", //环信ID
 "uuid": "939913BF5BEB46A29047BE66399BC1A0",   //用户表中主键
 "username": "android"  //用户名
 }
 }
 */


public class UserResult {

    private int code;

    @SerializedName("msg")
    private String message;

    private User data;

    //alt + insert

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public User getData() {
        return data;
    }
}
