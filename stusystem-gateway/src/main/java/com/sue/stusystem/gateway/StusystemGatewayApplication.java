package com.sue.stusystem.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StusystemGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StusystemGatewayApplication.class, args);
    }

}
