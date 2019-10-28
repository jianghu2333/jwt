package com.jianghu.jwt.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jianghu.jwt.exception.BaseException;
import com.jianghu.jwt.pojo.User;
import com.jianghu.jwt.properties.JwtProperties;
import com.jianghu.jwt.repository.UserRepository;
import com.jianghu.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

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
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        Date expired = calendar.getTime();

        HashMap<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create().withHeader(map).withClaim("id", user.getId()).withClaim("username", username).withExpiresAt(expired).withIssuedAt(now).sign(Algorithm.HMAC256(JwtProperties.SECRET));
        System.out.println(token);
        return null;
    }

}
