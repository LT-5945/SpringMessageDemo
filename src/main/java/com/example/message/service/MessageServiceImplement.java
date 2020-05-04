package com.example.message.service;

import com.example.message.dao.MessageDaoImplement;
import com.example.message.entity.Message;
import com.example.message.entity.MessageEntity;
import com.example.message.entity.SendMessageEntity;
import com.example.message.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

@RestController
public class MessageServiceImplement implements MessageService {
    static Log log=LogFactory.get(WebSocketServer.class);
    @Autowired
    MessageDaoImplement mdi;

    @PostMapping("/send")
    @Override
    public int send(@RequestBody MessageEntity msg) {//目的是存入数据库留下记录
        String host_id = msg.getHost_id();
        String guest_id = msg.getGuest_id();
        String message = msg.getMessage();
        int msg_type = msg.getMsg_type();
        int flag=mdi.send(host_id, guest_id, message, msg_type);
        if(flag==500){
            return 406;//朋友列表为空
        }
        else if(flag==404){
            return 404;//查无此朋友
        }
        return 200;
    }

    @RequestMapping("/push/{toUid}")
    @Override
    public String push(MessageEntity msg, @PathVariable String toUid) {
        Message sendMsg = new Message(msg.getGuest_id(),msg.getMessage());
        WebSocketServer wss = new WebSocketServer();
        //待完善
        return "200";
    }

    @PostMapping("/getMsg")
    @Override
    //获取的令牌按目前的设计是一次发送，再也不管这条信息了，所以等websocket赶紧做好！！！！！！
    public String getMsg(@RequestBody SendMessageEntity sendMsg) {
        String host_id = sendMsg.getHost_id();
        String guest_id = sendMsg.getGuest_id();
        return mdi.get(host_id, guest_id);
    }
}
