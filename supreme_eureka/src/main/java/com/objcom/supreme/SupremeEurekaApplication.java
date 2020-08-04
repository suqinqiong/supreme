package com.objcom.supreme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SupremeEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupremeEurekaApplication.class,args);
    }
}
