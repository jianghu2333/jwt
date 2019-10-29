package com.jianghu.jwt.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_user")
public class User implements Serializable {
    @Id
    private Long id;
    private String username;
    @Column(name = "password")
    private String password;
    private String phone;
    private String createTime;
}
