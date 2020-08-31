package com.fs.smartTown.modules.auth.service.impl;

import com.fs.smartTown.modules.auth.dao.UserRepository;
import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.auth.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        user.setCreateTime(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) throws Exception {
        if (user.getUserId() == null){
            throw new Exception("更新异常：没有用户id");
        }
        user.setUpdateTime(new Date());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
