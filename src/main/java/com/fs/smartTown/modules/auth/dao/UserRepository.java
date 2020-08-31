package com.fs.smartTown.modules.auth.dao;

import com.fs.smartTown.modules.auth.entity.Role;
import com.fs.smartTown.modules.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findByUserId(Integer userId);
}
