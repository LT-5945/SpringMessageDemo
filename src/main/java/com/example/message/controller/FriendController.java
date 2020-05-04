package com.example.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FriendController {
    @RequestMapping("/findfriend")
    public String find(){return "/findfriend";}
/*
    @RequestMapping("/queryFriend")
    public String query(){return "/queryFriend";}

 */
}
