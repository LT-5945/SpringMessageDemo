package com.example.message.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MessageDaoImplement implements MessageDao {
    private JdbcTemplate jdbcTemplate;

    //为什么要写这个构造函数呢？是为了Bean的注入吗？
    public MessageDaoImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int send(String uid, String friend_uid, String message) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String msg_id = uid + friend_uid + df.format(new Date());// new Date()为获取当前系统时间
        return jdbcTemplate.update("INSERT INTO message(msg_id,host_id, guest_id, message) values (?,?,?,?)",
                msg_id, uid, friend_uid, message);
    }
}
