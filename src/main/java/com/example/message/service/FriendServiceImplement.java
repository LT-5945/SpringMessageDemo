package com.example.message.service;

import com.example.message.dao.FriendDaoImplement;
import com.example.message.entity.FriendEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendServiceImplement implements FriendService{
    @Autowired
    FriendDaoImplement fdi;

    @PostMapping("/findfriend")
    @Override
    public String addFriendByUid(@RequestBody FriendEntity friend) {
        String uid = friend.getUid();
        String friend_uid = friend.getFriend_uid();
        String username = fdi.findFriendByUid(friend_uid);//获取用户名，为以后的确认加好友界面作准备，目前暂时不做该页面跳转
        if(username.equals("Empty")){//接受返回的"Empty"朋友列表为空
            return "user not found";
        }
        int flag = fdi.insertFriend(uid, friend_uid);//加好友
        return Integer.toString(flag);//可以为404或1
    }
}
