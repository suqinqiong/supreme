package com.objcom.supreme.feign.fallback;

import com.objcom.supreme.domain.User;
import com.objcom.supreme.feign.UserClient;
import org.springframework.stereotype.Component;

/**
 * Feign 对hystrix熔断器的支持
 */
@Component
public class UserClientFallback implements UserClient {

    /**
     * 服务降级实现
     * @param id id
     * @return user
     */
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("Fallback,Feign服务降级...");
        return user;
    }
}
