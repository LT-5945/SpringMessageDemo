package com.example.message.service;

import com.example.message.entity.MessageEntity;

public interface MessageService {
    String send(MessageEntity msg);
    //String push(MessageEntity msg, String toUid);
}
