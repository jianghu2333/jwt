package com.jianghu.jwt.service;

import com.jianghu.jwt.pojo.User;

public interface UserService {
    User findByUserAndPassword(String username,String password) throws Exception;
}
