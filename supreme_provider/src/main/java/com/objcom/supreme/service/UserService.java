package com.objcom.supreme.service;

import com.objcom.supreme.domain.User;

public interface UserService {
 /***
 * 根据 ID 查询用户信息
 * @param id 
 * @return 
 */
 public User findByUserId(Integer id);
}