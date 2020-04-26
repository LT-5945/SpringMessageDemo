package com.example.message.entity;

import lombok.Data;

@Data
public class MessageEntity {
    //private String msg_id;
    private String host_id;
    private String guest_id;
    private String message;


    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public String getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(String guest_id) {
        this.guest_id = guest_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
