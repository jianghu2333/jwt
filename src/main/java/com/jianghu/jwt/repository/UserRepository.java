package com.jianghu.jwt.repository;

import com.jianghu.jwt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByUserNameAndAndPassword(String username,String password);
}
