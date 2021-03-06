package com.sue.stusystem.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.sue.stusystem.query.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class StusystemQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(StusystemQueryApplication.class, args);
    }

}
