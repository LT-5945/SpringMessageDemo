package com.example.message.service;

import com.example.message.entity.FriendEntity;
import com.example.message.entity.QueryFriendEntity;

public interface FriendService {

    String addFriendByUid(FriendEntity friend);
    String queryFriendByUid(QueryFriendEntity query);
    String insertFriend();
}
