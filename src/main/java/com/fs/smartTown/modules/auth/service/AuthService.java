package com.fs.smartTown.modules.auth.service;

import com.fs.smartTown.modules.auth.entity.SysToken;
import com.fs.smartTown.modules.auth.entity.User;

import java.util.Map;

public interface AuthService {
    /**
     * Find user by username
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * create token by userId
     * @param userId
     * @return
     */
    Map<String,Object> createToken(Integer userId);

    /**
     * logout
     * @param token
     */
    void logout(String token);

    /**
     * find token by token
     * @param accessToken
     * @return
     */
    SysToken findByToken(String accessToken);

    /**
     * find user by userId
     * @param userId
     * @return
     */
    User findByUserId(Integer userId);
}
