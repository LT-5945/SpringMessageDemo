package com.example.message.dao;

public interface FriendDao {
    /**
     *
     * @param uid
     * @return
     */
    String findFriendByUid(String friend_uid);

    String findPhoneNumByUid(String friend_uid);

    /**
     *
     * @param uid
     * @return
     */
    int insertFriend(String uid, String friend_uid);
}
