package com.example.message.dao;

//message的产生和发送
public interface MessageDao {
    int send(String uid, String friend_uid, String message, int msg_type);
    String get(String host_id, String guest_id);
}
