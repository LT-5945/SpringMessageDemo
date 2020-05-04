package com.example.message.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class QueryFriendEntity {
    @JSONField(name="friend_uid")
    private String friend_uid;
    @JSONField(name="username")
    private String username;
    @JSONField(name="phoneNum")
    private String phoneNum;

    public QueryFriendEntity(String friend_uid, String username, String phoneNum) {
        this.friend_uid=friend_uid;
        this.username=username;
        this.phoneNum=phoneNum;
    }

    public String getFriend_uid() {
        return friend_uid;
    }

    public void setFriend_uid(String friend_uid) {
        this.friend_uid = friend_uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
