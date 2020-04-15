package com.sue.stusystem.query.controller;

import com.sue.stusystem.query.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @Autowired
    private FeignService feignService;
    @RequestMapping("/feign")
    @ResponseBody
    public String feignQuery() {
        return  feignService.query();
    }


}
