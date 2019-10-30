package com.jianghu.jwt.controller;

import com.jianghu.jwt.pojo.User;
import com.jianghu.jwt.service.UserService;
import com.jianghu.jwt.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultVo register(@RequestBody User user) throws Exception {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResultVo login(@RequestBody User user) throws Exception {
        return userService.findByUserAndPassword(user.getUsername(), user.getPassword());
    }

    @PutMapping("/update")
    public ResultVo update(@RequestBody User user) throws Exception {
        return userService.updateUser(user);
    }

}
