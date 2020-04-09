package com.sue.stusystem.server2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class MyController {

    @RequestMapping("/index")
    public String ToIndex() {
        System.out.println("===");
        return "login";
    }

    @RequestMapping("/loginning")
    public String Login(String username,String password,String redirectUrl,HttpSession session,Model model) {
        System.out.println("username="+username+"&password="+password+"  redirectUrl="+redirectUrl);
        if("admin".equals(username)&&"123456".equals(password)) {
            System.out.println("success");
            String token = UUID.randomUUID().toString();
            session.setAttribute("token",token);

//            session.setAttribute("isLogin",true);
            return "redirect:"+redirectUrl+"?token="+token;

        }
        model.addAttribute("redirectUrl",redirectUrl);
        System.out.println("false");
        return "login";
    }

    @RequestMapping("/checkLogin")
    public String checkLogin(String redirectUrl, HttpSession session, Model model) {
        String token = (String)session.getAttribute("token");
        if(StringUtils.isEmpty(token)) {
            model.addAttribute("redirectUrl",redirectUrl);
            System.out.println("===");
            return "login";
        }
        model.addAttribute("token",token);
        return "redirect:"+redirectUrl;


    }

    @GetMapping("/checkToken")
    @ResponseBody
    public String checkToken(String token) {

        System.out.println("ckeck token");
        return "true";



    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:www.client.com:9001/system";
    }
}
