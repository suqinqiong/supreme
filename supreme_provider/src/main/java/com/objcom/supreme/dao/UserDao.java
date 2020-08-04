package com.objcom.supreme.dao;

import com.objcom.supreme.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}