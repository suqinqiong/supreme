package com.objcom.supreme.controller;

import com.objcom.supreme.domain.User;
import com.objcom.supreme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    /***
     * 根据 ID 查询用户信息
     * @param id id
     * @return user
     */
    @RequestMapping(value = "find/{id}")
    public User findById(@PathVariable(value = "id") Integer id) {
        User user = userService.findByUserId(id);
        user.setUsername(user.getUsername() + " supreme-provider");
        return user;
    }
}