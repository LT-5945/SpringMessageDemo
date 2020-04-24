package com.example.message.service;

import com.example.message.entity.LoginByUidEntity;
import com.example.message.entity.SigninEntity;

public interface UserService {
    String signin(SigninEntity signin);
    String loginByUid(LoginByUidEntity login);
}
