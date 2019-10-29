package com.jianghu.jwt.service;

import com.jianghu.jwt.exception.BaseException;
import com.jianghu.jwt.pojo.User;
import com.jianghu.jwt.vo.ResultVo;

public interface UserService {
    ResultVo findByUserAndPassword(String username, String password) throws Exception;

    ResultVo updateUser(User user) throws BaseException;

    ResultVo register(User user) throws BaseException;
}
