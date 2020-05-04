package com.example.message.service;

import com.example.message.entity.FriendEntity;
import com.example.message.entity.QueryFriendEntity;

public interface FriendService {
    /**
     *
     * @param friend
     * @return
     */
    int addFriendByUid(FriendEntity friend);
    String queryFriendByUid(QueryFriendEntity query);
}
