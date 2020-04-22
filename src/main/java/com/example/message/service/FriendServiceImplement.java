package com.example.message.service;

import com.example.message.dao.FriendDaoImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendServiceImplement implements FriendService{
    @Autowired
    FriendDaoImplement fdi;

    @PostMapping("/findfriend")
    @Override
    public String addFriendByUid(@RequestParam String uid, @RequestParam String friend_uid) {
        String username = fdi.findFriendByUid(friend_uid);//获取用户名，为以后的确认加好友界面作准备，目前暂时不做该页面跳转
        if(username.equals("null")){//接受返回的"null"
            return "user not found";
        }
        int flag = fdi.insertFriend(uid, friend_uid);//bug: 这一步执行后无效果,原因是网上给的COMCAT函数mysql报错
        return Integer.toString(flag);
    }
}
