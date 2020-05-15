package com.example.message.service;

import com.example.message.dao.UserDaoImplement;
import com.example.message.entity.LoginByUidEntity;
import com.example.message.entity.SigninEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserServiceImplement implements UserService {
    @Autowired
    UserDaoImplement udi;
    @PostMapping("/signin")
    @Override
    public int signin(@RequestBody SigninEntity signin){
        String uid = signin.getUid();
        String username = signin.getUsername();
        String password = signin.getPassword();
        String phoneNum = signin.getPhoneNum();
        int state = udi.create(uid,username,password,phoneNum);
        if(state >0){
            return 200;
        }
        else{
            return 400;
        }
    }

    @PostMapping("/login")
    @Override
    //此处接受的json内的变量命名必须和@RequestBody中的对象内变量名严格对应
    public int loginByUid(@RequestBody LoginByUidEntity login, HttpSession session) {//可以直接接受json，但是需要调整UserEntity，换一个类来接收
        String uid = login.getUid();
        String password= login.getPassword();
        Object sessionUid = session.getAttribute("uid");
        String result = udi.logInByUid(uid, password);
        System.out.print(result);
        if(result.equals("success")){
            return 200;//状态码的返回和前端沟通后再说。
        }
        else{
            return 400;
        }
    }

    @PostMapping("/check")
    @Override
    public int checkSession(LoginByUidEntity login, HttpSession session){
        Object sessionUid = session.getAttribute("uid");
        String uid = login.getUid();
        String password= login.getPassword();
        if(sessionUid == null){
            System.out.println("不存在session，uid=" + uid);
            session.setAttribute("uid", uid);
            return 400;//没有session
        }else{
            return 200;//有session，访问login接口
        }

    }
}
