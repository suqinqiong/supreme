package com.objcom.supreme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient//开启Eureka客户端发现功能
@EnableConfigServer//开启配置服务支持
public class SupremeConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupremeConfigApplication.class,args);
    }
}
