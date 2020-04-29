package com.example.message.entity;

public class SendMessageEntity {
    private String host_id;
    private String guest_id;
    private String hub_id;

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

    public String getHub_id() {
        return hub_id;
    }

    public void setHub_id(String hub_id) {
        this.hub_id = hub_id;
    }
}
