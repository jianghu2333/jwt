package com.jianghu.jwt.repository;

import com.jianghu.jwt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
