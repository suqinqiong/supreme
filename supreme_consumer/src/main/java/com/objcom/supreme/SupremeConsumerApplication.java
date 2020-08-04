package com.objcom.supreme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //开启Eureka发现服务
@EnableCircuitBreaker //开启熔断器
@EnableFeignClients //开启Feign客户端
public class SupremeConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupremeConsumerApplication.class, args);
    }

    /***
     * 将 RestTemplate 的实例放到 Spring 容器中
     * @return restTemplate
     */
    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}