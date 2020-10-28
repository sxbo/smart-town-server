package com.fs.smartTown.modules.auth.dao;

import com.fs.smartTown.modules.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findByUserId(Integer userId);
    User findUserByOpenId(String openId);
    List<User> findAllByUsernameContaining(String roleName);
}
