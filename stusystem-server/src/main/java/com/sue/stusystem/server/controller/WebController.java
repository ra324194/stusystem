package com.sue.stusystem.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {

    @RequestMapping("/hello")
    public String ToIndex() {
        return "index";
    }
    @RequestMapping("/thank")
    public String ToSuccess() {
        return "success";
    }
}
