package com.example.administrator.myeasyshop.model;

import com.google.gson.annotations.SerializedName;

/**
 "other": "/images/8A572F08CE874555A80034CDC104CB82/D28584D018.jpg", //头像路径
 "name": "yt6e2ea5da01e846e198d5cc9146a0919b", //环信ID
 "nickname": "翡翠产品",  //昵称
 "uuid": "8A572F08CE874555A80034CDC104CB82",  //用户表中主键
 "username": "feicuicp" //用户名
 "password":"123456"
 */

public class User {
    @SerializedName("name")
    private String hx_Id;
    @SerializedName("uuid")
    private String table_Id;
    @SerializedName("username")
    private String name;
    @SerializedName("other")
    private String head_Image;
    @SerializedName("nickname")
    private String nick_name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHead_Image() {
        return head_Image;
    }

    public void setHead_Image(String head_Image) {
        this.head_Image = head_Image;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public void setHx_Id(String hx_Id) {
        this.hx_Id = hx_Id;
    }

    public void setTable_Id(String table_Id) {
        this.table_Id = table_Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHx_Id() {
        return hx_Id;
    }

    public String getTable_Id() {
        return table_Id;
    }

    public String getName() {
        return name;
    }
}
