package com.example.message.service;

import com.example.message.entity.MessageEntity;
import com.example.message.entity.SendMessageEntity;

public interface MessageService {
    int send(MessageEntity msg);
    String push(MessageEntity msg, String toUid);
    String getMsg(SendMessageEntity sendMsg);
}
