package com.sue.stusystem.commonutil.controller;

import com.sue.stusystem.commonutil.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
@RefreshScope
@Controller
public class MyController {
    @Autowired
    private ClassMapper classMapper;
    @Value("${sue.user.name}")
    private String name;

    @RequestMapping("/query")
    @ResponseBody
    public String query() {
        return classMapper.selectById(10000000).toString();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {

        return name;
    }


}
