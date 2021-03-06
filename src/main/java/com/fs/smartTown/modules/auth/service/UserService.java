package com.fs.smartTown.modules.auth.service;

import com.fs.smartTown.modules.auth.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> getUsers();

    /**
     * 更新用户
     *
     * @param user
     * @return
     * @throws Exception id为空
     */
    User updateUser(User user) throws Exception;

    /**
     * 更新用户
     *
     * @param user
     * @return
     * @throws Exception id为空
     */
    User updateUser(User user, String phone) throws Exception;

    /**
     * 删除用户
     *
     * @param
     * @return
     */
    void deleteUser(Integer userId);

    User findUserByOpenId(String openId);

    User findUserByUserName(String userName);

    User findUserByUserId(Integer userId);
    List<User>  findUsersByUserNameLike(String userName);
}
