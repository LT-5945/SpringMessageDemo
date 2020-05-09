package com.example.message.controller;

import com.example.message.entity.LoginByUidEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, HttpServletRequest request, HttpSession session){
        //取出session中的browser
        Object sessionBrowser = session.getAttribute("username");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置username=" + username);
            session.setAttribute("username", username);
            return "/login";
        } else {
            System.out.println("存在session，username=" + sessionBrowser.toString());
            System.out.println("存在session=" + session.toString());
            return "/findfriend";
        }
    }
}
