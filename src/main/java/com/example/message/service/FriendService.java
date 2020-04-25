package com.example.message.service;

import com.example.message.entity.FriendEntity;

public interface FriendService {
    /**
     *
     * @param friend
     * @return
     */
    String addFriendByUid(FriendEntity friend);
}
