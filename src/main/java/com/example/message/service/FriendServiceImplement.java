package com.example.message.service;

import com.alibaba.fastjson.JSON;
import com.example.message.dao.FriendDaoImplement;
import com.example.message.entity.FriendEntity;
import com.example.message.entity.QueryFriendEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
            return "404";//user not found
        }
        String friend_uid_list = fdi.insertFriend(uid, friend_uid);//加好友
        String result="{" + "\"friend_uid_list\":"+"\""+friend_uid_list+"\""+"}";
        return result;
    }

    @PostMapping("queryFriend")
    @Override
    public String queryFriendByUid(@RequestBody QueryFriendEntity query){
        String friend_uid = query.getFriend_uid();
        List<QueryFriendEntity> respond = new ArrayList<QueryFriendEntity>();
        respond.add(new QueryFriendEntity(friend_uid,fdi.findFriendByUid(friend_uid),fdi.findPhoneNumByUid(friend_uid)));
        String jsonOut = JSON.toJSONString(respond);
        return jsonOut;
    }
}
