package com.sue.stusystem.commonutil;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.sue.stusystem.commonutil.mapper")
public class CommonUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonUtilApplication.class, args);
    }

}
