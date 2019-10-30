package com.jianghu.jwt.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jianghu.jwt.exception.BaseException;
import com.jianghu.jwt.pojo.User;
import com.jianghu.jwt.properties.JwtProperties;
import com.jianghu.jwt.repository.UserRepository;
import com.jianghu.jwt.service.UserService;
import com.jianghu.jwt.utils.MD5;
import com.jianghu.jwt.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResultVo findByUserAndPassword(String username, String password) throws BaseException {
        User user = userRepository.findByUsernameAndPassword(username, password);
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
        ResultVo resultVo = new ResultVo();
        resultVo.setCode("11000");
        resultVo.setObject(token);
        return resultVo;
    }

    @Override
    public ResultVo updateUser(User user) throws BaseException {
        if (user == null) {
            throw new BaseException(10001, "用户信息不能为空");
        }
        if (StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(MD5.getMd5(user.getPassword()));
        }
        User save = userRepository.save(user);
        ResultVo resultVo = new ResultVo();
        resultVo.setCode("11000");
        resultVo.setObject("修改成功");
        return resultVo;
    }

    @Override
    public ResultVo register(User user) throws BaseException {
        if (StringUtils.isBlank(user.getPassword())) {
            throw new BaseException(10003, "密码不能为空");
        }
        user.setPassword(MD5.getMd5(user.getPassword()));
        user.setCreateTime(new Date());
        userRepository.save(user);
        ResultVo resultVo = new ResultVo();
        resultVo.setCode("11000");
        resultVo.setObject("注册成功");
        return resultVo;
    }

}
