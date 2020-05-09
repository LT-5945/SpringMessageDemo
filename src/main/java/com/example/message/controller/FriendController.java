package com.example.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class FriendController {
    @RequestMapping("/findfriend")
    public String find(HttpServletRequest request, HttpSession session){
        Object sessionBrowser = session.getAttribute("browser");
        String browser = "chrome";
        if (sessionBrowser == null) {
            return "/login";
        } else {

            return "/findfriend";
        }
    }
/*
    @RequestMapping("/queryFriend")
    public String query(){return "/queryFriend";}

 */
}
