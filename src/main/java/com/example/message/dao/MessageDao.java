package com.example.message.dao;

//message的产生和发送
public interface MessageDao {
    int send(String uid, String friend_uid, String message);
    String get(String host_id, String guest_id, String hub_id);
}
