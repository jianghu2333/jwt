package com.jianghu.jwt.service.impl;

import com.jianghu.jwt.exception.BaseException;
import com.jianghu.jwt.pojo.User;
import com.jianghu.jwt.repository.UserRepository;
import com.jianghu.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserAndPassword(String username, String password) throws Exception {
        User user = userRepository.findByUserNameAndAndPassword(username, password);
        if (user == null) {
            throw new BaseException(10000, "暂无该用户");
        }
        return null;

    }
}
