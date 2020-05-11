package com.example.message.dao;

import com.alibaba.fastjson.JSON;
import com.example.message.entity.MessageEntity;
import com.example.message.entity.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MessageDaoImplement implements MessageDao {
    private JdbcTemplate jdbcTemplate;

    //为什么要写这个构造函数呢？是为了Bean的注入吗？
    public MessageDaoImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override//将信息插入数据库
    public int send(String host_id, String guest_id, String message, int msg_type) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String msg_id = host_id + guest_id + df.format(new Date());// new Date()为获取当前系统时间
        List<UserEntity> userInfo = jdbcTemplate.query("SELECT friend_uid_list FROM user WHERE uid = ?",
                (resultSet, i) -> {
                    UserEntity user = new UserEntity();
                    user.setFriendUidList(resultSet.getString("friend_uid_list"));
                    return user;
                }, host_id);//查询自己的friend_uid_list
        UserEntity user = userInfo.get(0);//非空，new出的对象内元素皆为null
        String friend_uid_list = user.getFriendUidList();
        if(friend_uid_list == null || friend_uid_list.isEmpty()){//如果为空
            return 406;//朋友列表为空
        }
        Pattern pattern = Pattern.compile(guest_id);
        Matcher matcher = pattern.matcher(friend_uid_list);
        boolean result = matcher.find();
        if(!result){
            return 404;//查无此朋友
        }
        return jdbcTemplate.update("INSERT INTO message(msg_id,host_id,guest_id,message,msg_type) values(?,?,?,?,?)",
                msg_id, host_id, guest_id, message, msg_type);
    }

    @Override//客人主动获取
    public String get(String host_id, String guest_id) {
        List<MessageEntity> msgInfo = jdbcTemplate.query("SELECT * FROM message " +
                "WHERE host_id=? AND guest_id=?",
                (resultSet,i) ->{
                    MessageEntity me = new MessageEntity();
                    me.setHost_id(resultSet.getString("host_id"));
                    me.setGuest_id(resultSet.getString("guest_id"));
                    me.setMessage(resultSet.getString("message"));
                    me.setMsg_type(resultSet.getInt("msg_type"));
                    return me;
                },host_id,guest_id);
        if(msgInfo.isEmpty()){
            return "NOT FOUND";
        }
        int size = msgInfo.size();
        String respond = "[";
        for(int i=0;i<size-1;i++){
            MessageEntity msg = msgInfo.get(i);
            respond = respond + JSON.toJSONString(msg) + ",";
        }
        respond = respond + JSON.toJSONString(msgInfo.get(size-1)) + "]";
        return respond;
    }

    @Override
    public int delete(String host_id, String guest_id){
        return jdbcTemplate.update("DELETE FROM message WHERE host_id=? AND guest_id=?",host_id,guest_id);
    }
}
