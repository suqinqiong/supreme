package com.objcom.supreme.feign;

import com.objcom.supreme.domain.User;
import com.objcom.supreme.feign.conf.FeignConfig;
import com.objcom.supreme.feign.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign 客户端入门
 * Feign 会通过动态代理，帮我们生产实现类
 * 注解@FeignClient 声明 Feign的客户端，注解value指明服务名称
 * 接口定义的方法，采用SpringMVC的注解，Feign会根据注解帮我们生产URL地址
 * 注解@RequestMapping中的/user,不要忘记同时建议不要放在类的头部，因为Feign需要拼接可访问地址
 */
@FeignClient(value = "supreme-provider",
        fallback = UserClientFallback.class, //配置熔断器
        configuration = FeignConfig.class //配置日志级别
)//声明Feign的客户端，value:填写生产者的名称
public interface UserClient {

    /**
     * 注意：此处的请求地址一定和生产者请求地址一样
     * @param id id
     * @return user
     */
    @RequestMapping("/user/find/{id}")
    User findById(@PathVariable("id")Integer id);
}
