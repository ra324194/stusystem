package com.sue.stusystem.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class StusystemServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StusystemServerApplication.class, args);
    }

}
