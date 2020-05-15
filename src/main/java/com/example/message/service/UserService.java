package com.example.message.service;

import com.example.message.entity.LoginByUidEntity;
import com.example.message.entity.SigninEntity;

import javax.servlet.http.HttpSession;

public interface UserService {
    int signin(SigninEntity signin);
    int loginByUid(LoginByUidEntity login, HttpSession session);
    int checkSession(LoginByUidEntity login, HttpSession session);
}
