package com.objcom.supreme.service.impl;

import com.objcom.supreme.dao.UserDao;
import com.objcom.supreme.domain.User;
import com.objcom.supreme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(Integer id) {
        return userDao.findById(id).get();
    }
}