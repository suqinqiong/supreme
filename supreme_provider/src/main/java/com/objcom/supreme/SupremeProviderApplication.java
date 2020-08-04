package com.objcom.supreme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//向Eureka注册服务
public class SupremeProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupremeProviderApplication.class,args);
    }
}
