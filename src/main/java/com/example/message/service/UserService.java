package com.example.message.service;

import com.example.message.entity.LoginByUidEntity;
import com.example.message.entity.SigninEntity;

public interface UserService {
    int signin(SigninEntity signin);
    int loginByUid(LoginByUidEntity login);
}
