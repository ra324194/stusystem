package com.sue.stusystem.query.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("common-util")
public interface FeignService {

    @RequestMapping("/query")
    @ResponseBody
    public String query();
}
