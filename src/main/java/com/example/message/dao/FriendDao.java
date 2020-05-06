package com.example.message.dao;

public interface FriendDao {

    String findFriendByUid(String friend_uid);

    String findPhoneNumByUid(String friend_uid);

    String insertFriend(String uid, String friend_uid);
}
