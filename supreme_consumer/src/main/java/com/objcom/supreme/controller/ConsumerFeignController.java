package com.objcom.supreme.controller;

import com.objcom.supreme.domain.User;
import com.objcom.supreme.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class ConsumerFeignController {
    @Autowired
    private UserClient userClient;
    @RequestMapping("{id}")
    public User findById(@PathVariable("id")Integer id){
        User user = userClient.findById(id);
        return user;
    }
}
