package com.jianghu.jwt.controller;

import com.jianghu.jwt.pojo.User;
import com.jianghu.jwt.service.UserService;
import com.jianghu.jwt.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultVo register(User user) throws Exception {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResultVo login(User user) throws Exception {
        return userService.findByUserAndPassword(user.getUsername(), user.getPassword());
    }

    @PostMapping("/update")
    public ResultVo update(User user) throws Exception {
        return userService.updateUser(user);
    }

}
