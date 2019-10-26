package com.jianghu.jwt.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "tb_user")
public class User {
    private Long id;
    private String userName;
    private String password;
    private String phone;
    private String createTime;
}
