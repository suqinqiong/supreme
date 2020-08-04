package com.objcom.supreme.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.objcom.supreme.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "consumer")
@DefaultProperties(defaultFallback = "defaultFailBack")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 在 user-consumer 服务中通过 RestTemplate 调用 user-provider 服务
     *
     * @param id id
     * @return user
     */
    @GetMapping(value = "/{id}")
//    @HystrixCommand(fallbackMethod = "failBack") // 方法如果处理出问题，就调用降级处理方法
    @HystrixCommand
    public User queryById(@PathVariable(value = "id") Integer id) {
        /*
        //方法1.通过IP&port
        String url = "http://localhost:18081/user/find/"+id;
        return restTemplate.getForObject(url,User.class);
        */

        /*
        //方法2.通过指定生产者实例对象
        //获取指定生产者的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("supreme_provider");
        //获取第一个实例对象
        ServiceInstance instance = instances.get(0);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/find/" + id;
        */

        //方法3.通过生产者名称 (Ribbon不识别下划线，改成横线正常)
        String url = "http://supreme-provider/user/find/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

    /**
     * 全局的服务降级处理方法
     * @return user
     */
    public User defaultFailBack() {
        User user = new User();
        user.setUsername("Default-全局服务降级的默认处理方法！");
        return user;
    }

    /**
     * 服务降级处理方法
     *
     * @param id id
     * @return user
     */
    public User failBack(Integer id) {
        User user = new User();
        user.setUsername("服务降级，默认处理！");
        return user;
    }
}