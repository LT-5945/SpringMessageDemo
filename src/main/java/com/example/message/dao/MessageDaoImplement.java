package com.example.message.dao;

import com.example.message.entity.Message;
import com.example.message.entity.MessageEntity;
import com.example.message.entity.SendMessageEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageDaoImplement implements MessageDao {
    private JdbcTemplate jdbcTemplate;

    //为什么要写这个构造函数呢？是为了Bean的注入吗？
    public MessageDaoImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override//将信息插入数据库
    public int send(String uid, String friend_uid, String message) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String msg_id = uid + friend_uid + df.format(new Date());// new Date()为获取当前系统时间
        return jdbcTemplate.update("INSERT INTO message(msg_id,host_id, guest_id, message) values (?,?,?,?)",
                msg_id, uid, friend_uid, message);
    }

    @Override//客人主动获取
    public String get(String host_id, String guest_id, String hub_id) {
        List<MessageEntity> msgInfo = jdbcTemplate.query("SELECT message FROM message " +
                "WHERE host_id=? AND guest_id=? AND hub_id=?",
                (resultSet,i) ->{
                    MessageEntity me = new MessageEntity();
                    me.setMessage(resultSet.getString("message"));
                    return me;
                },host_id,guest_id,hub_id);
        MessageEntity msg = msgInfo.get(0);
        if(msg.equals("null")){
            return "NOT FOUND";
        }
        return msg.getMessage();
    }
}
