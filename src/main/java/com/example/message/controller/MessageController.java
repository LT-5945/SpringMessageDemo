package com.example.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
    @RequestMapping("/send")
    public String send(){return "/send";}
    /*
    @RequestMapping("/push/")
    public String get(){return "/get";}

    @RequestMapping("/getMsg")
    public String getMsg(){return "/getMsg";}
     */

}
