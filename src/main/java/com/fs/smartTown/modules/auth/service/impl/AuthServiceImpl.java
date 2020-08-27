package com.fs.smartTown.modules.auth.service.impl;

import com.fs.smartTown.modules.auth.TokenGenerator;
import com.fs.smartTown.modules.auth.dao.SysTokenRepository;
import com.fs.smartTown.modules.auth.dao.UserRepository;
import com.fs.smartTown.modules.auth.entity.SysToken;
import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.auth.service.AuthService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService{
    //12小时后失效
    private final static int EXPIRE = 12;
    private final UserRepository userRepository;
    private final SysTokenRepository sysTokenRepository;

    public AuthServiceImpl(UserRepository userRepository, SysTokenRepository sysTokenRepository) {
        this.userRepository = userRepository;
        this.sysTokenRepository = sysTokenRepository;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public Map<String, Object> createToken(Integer userId) {
        Map<String, Object> result = new HashMap<>();
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        LocalDateTime now = LocalDateTime.now();
        //过期时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);
        //判断是否生成过token
        SysToken tokenEntity  = sysTokenRepository.findByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysToken();
            tokenEntity.setUserId(userId);
            //保存token
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
        }else {
            //更新token
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
        }
        sysTokenRepository.save(tokenEntity);
        result.put("token", token);
        result.put("expire", expireTime);
        return result;
    }

    /**
     * 更新数据库的token，使前端拥有的token失效
     * 防止黑客利用token搞事情
     *
     * @param token
     */
    @Override
    public void logout(String token) {
        SysToken byToken = findByToken(token);
        //生成一个token
        token = TokenGenerator.generateValue();
        //修改token
        byToken.setToken(token);
        //使前端获取到的token失效
        sysTokenRepository.save(byToken);
    }

    @Override
    public SysToken findByToken(String accessToken) {
        return sysTokenRepository.findByToken(accessToken);

    }

    @Override
    public User findByUserId(Integer userId) {
        return userRepository.findByUserId(userId);
    }
}
