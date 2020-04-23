package com.example.message.service;

import com.example.message.dao.UserDaoImplement;
import com.example.message.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImplement implements UserService {
    @Autowired
    UserDaoImplement udi;

    @PostMapping("/login")
    @Override
    public String loginByUid(@RequestBody UserEntity user) {//可以直接接受json，但是需要调整UserEntity，换一个类来接收
        String uid = user.getUid();
        String givenPWD= user.getPassword();
        String result = udi.logInByUid(uid, givenPWD);
        System.out.print(result);
        if(result.equals("success")){
            return "200";
        }
        else{
            return result;
        }
    }
}
