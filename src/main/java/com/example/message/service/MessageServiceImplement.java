package com.example.message.service;

import com.example.message.dao.MessageDaoImplement;
import com.example.message.entity.Message;
import com.example.message.entity.MessageEntity;
import com.example.message.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageServiceImplement implements MessageService {
    @Autowired
    MessageDaoImplement mdi;

    @PostMapping("/send")
    @Override
    public String send(@RequestBody MessageEntity msg) {//目的是存入数据库留下记录
        String uid = msg.getHost_id();
        String friend_uid = msg.getGuest_id();
        String message = msg.getMessage();
        mdi.send(uid, friend_uid, message);
        return "200";
    }
/*
    @RequestMapping("/push/{toUid}")
    @Override
    public String push(MessageEntity msg, @PathVariable String toUid) {
        Message sendMsg = new Message(msg.getGuest_id(),msg.getMessage());
        WebSocketServer wss = new WebSocketServer();
        wss.sendTo(sendMsg);
        return "200";
    }

 */
}
