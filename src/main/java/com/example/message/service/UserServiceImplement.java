package com.example.message.service;

import com.example.message.dao.UserDaoImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImplement implements UserService {
    @Autowired
    UserDaoImplement udi;

    @PostMapping("/login")
    @Override
    public String loginByUid(@RequestParam String uid, @RequestParam String givenPWD) {
        String result = udi.logInByUid(uid, givenPWD);
        if(result.equals("success")){
            return "success";
        }
        else{
            return result;
        }
    }
}
