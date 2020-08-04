package com.objcom.supreme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//开启Eureka客户端发现功能
public class SupremeGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupremeGatewayApplication.class,args);
    }
}
