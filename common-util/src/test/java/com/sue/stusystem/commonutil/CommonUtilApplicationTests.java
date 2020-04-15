package com.sue.stusystem.commonutil;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sue.stusystem.commonutil.entities.Class;
import com.sue.stusystem.commonutil.mapper.ClassMapper;
import com.sue.stusystem.commonutil.util.JedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class CommonUtilApplicationTests {
@Resource
private ClassMapper classMapper;
@Resource
private JedisUtil jedisUtil;
    @Test
    void contextLoads() {
        System.out.println(classMapper.selectById(10000000));




    }

}
