package com.example.message.entity;

import lombok.Data;

@Data
public class UserEntity {
    //按照目前的设计，用户可以用uid，phoneNum和username注册登陆
    private String uid;
    private String username;
    private String password;
    private String phoneNum;
    private String friendUidList;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getFriendUidList() {
        return friendUidList;
    }

    public void setFriendUidList(String friendUidList) {
        this.friendUidList = friendUidList;
    }
}