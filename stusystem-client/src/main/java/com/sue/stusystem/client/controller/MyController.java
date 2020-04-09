package com.sue.stusystem.client.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {
    @RequestMapping("/system")
    public String Index() {
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
       session.invalidate();
       return "redirect:http://www.sso.com:9100/logout";

    }
}
