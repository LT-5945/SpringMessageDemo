package com.example.message.service;

import com.example.message.dao.MessageDaoImplement;
import com.example.message.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageServiceImplement implements MessageService {
    @Autowired
    MessageDaoImplement mdi;

    @PostMapping("/send")
    @Override
    public String send(@RequestBody MessageEntity msg) {
        String uid = msg.getHost_id();
        String friend_uid = msg.getGuest_id();
        String message = msg.getMessage();
        mdi.send(uid, friend_uid, message);
        return "200";
    }
}
