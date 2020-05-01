package com.example.message.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

    private String userId;

    private String message;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }
}
