package com.fs.smartTown.modules.auth.controller;


import com.fs.smartTown.common.Constant;
import com.fs.smartTown.modules.auth.DTO.UpdateRoleDTO;
import com.fs.smartTown.modules.auth.DTO.WeChatAuthDTO;
import com.fs.smartTown.modules.auth.entity.Role;
import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.auth.service.RoleService;
import com.fs.smartTown.modules.auth.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(value = "用户管理apis")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @ApiOperation(value = "获取用户列表", tags = "user")
    @GetMapping("")
    public Map<String, Object> users() {
        Map<String, Object> result = new HashMap<>();
        List<User> users = userService.getUsers();
        result.put("data", users);
        result.put("status", 200);
        return result;
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("")
    public Map<String, Object> add(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            User addedUser = userService.addUser(user);
            result.put("data", addedUser);
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }

    @ApiOperation(value = "跟新用户")
    @PutMapping("")
    public Map<String, Object> update(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            User oldUser = userService.findUserByUserId(user.getUserId());
            if (oldUser.getPassword().equals(user.getOldPass())) {
                user.setCreateTime(oldUser.getCreateTime());
                if (!StringUtils.isEmpty(oldUser.getOpenId())){
                    user.setOpenId(oldUser.getOpenId());
                }
                User updater = userService.updateUser(user);
                result.put("data", updater);
                result.put("status", 200);
                result.put("msg", "添加成功");
            } else {
                result.put("data", "");
                result.put("status", 400);
                result.put("msg", "原密码错误");
            }

        } catch (Exception e) {
            result.put("data", null);
            result.put("status", 500);
            result.put("msg", "修改失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation(value = "查询用户信息用户")
    @GetMapping("getUserInfo")
    public Map<String, Object> getUserInfo(@RequestParam("userId") Integer userId) {
        Map<String, Object> result = new HashMap<>();
        try {
            User user = userService.findUserByUserId(userId);
            result.put("data", user);
            result.put("status", 200);
            result.put("msg", "获取用户信息成功");

        } catch (Exception e) {
            result.put("data", null);
            result.put("status", 203);
            result.put("msg", "获取用户信息失败");
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{userId}")
    public Map<String, Object> deleteUser(@PathVariable Integer userId) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.deleteUser(userId);
            result.put("data", userId);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "操作失败");
        }
        return result;
    }

    @ApiOperation(value = "微信用户认证")
    @PostMapping("/wx_auth")
    public Map<String, Object> weChantAuth(@RequestBody WeChatAuthDTO weChatAuthDTO, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        //DTO提示信息绑定
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            User user = null;
            if (!StringUtils.isEmpty(weChatAuthDTO.getOpenId())) {
                user = userService.findUserByOpenId(weChatAuthDTO.getOpenId());
                if (user == null) {
                    user = userService.findUserByUserName(weChatAuthDTO.getNickName());
                }
            }
            //不是第一次登陆，直接返回用户信息
            if (user != null) {
                result.put("data", user);
                result.put("status", 200);
                result.put("msg", "获取用户信息成功！");
                //第一次登陆，先保存后返回
            } else {
                //默认密码
                user = new User();
                String defaultPass = RandomStringUtils.random(8, "abcdefghijklmnopqrstuvwxyz1234567890");
                user.setPassword(Constant.INIT_PWD);
                user.setUsername(weChatAuthDTO.getNickName());
                Date date = new Date();
                user.setCreateTime(date);
                user.setUpdateTime(date);
                if (!StringUtils.isEmpty(weChatAuthDTO.getOpenId())) {
                    user.setOpenId(weChatAuthDTO.getOpenId());
                }
                /**
                 * 设置默认角色
                 */
                Set<Role> roles = roleService.findRolesByRoleName("普通用户");
                user.setRoles(roles);
                //添加用户
                userService.addUser(user);
                result.put("data", user);
                result.put("status", 200);
                result.put("msg", "获取用户信息成功！");
            }
        } catch (Exception e) {
            result.put("data", null);
            result.put("status", 500);
            result.put("msg", "获取用户信息失败！");
            throw e;
        }
        return result;
    }

    @ApiOperation(value = "设置用户角色: 参数：userId， roleIds")
    @PostMapping("/update_role")
    public Map<String, Object> setRolesByUserIdAndRoleIds(@RequestBody UpdateRoleDTO updateRoleDTO, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            User user = userService.findUserByUserId(updateRoleDTO.getUserId());
            List<Integer> roleIds = updateRoleDTO.getRoleIds();
            Set<Role> roles = roleService.findAllByIds(roleIds);
            user.setRoles(roles);
            userService.updateUser(user);
            result.put("data", user);
            result.put("status", 200);
            result.put("msg", "设置角色成功！");

        } catch (Exception e) {
            result.put("data", null);
            result.put("status", 500);
            result.put("msg", "设置角色失败！");
        }
        return result;
    }

    /**
     * 绑定手机号
     *
     * @param openId
     * @return
     */
    @ApiOperation(value = "绑定手机号: 参数：openId")
    @PostMapping("/bindPhone")
    public Map<String, Object> bindPhone(@RequestParam("openId") String openId,
                                         @RequestParam("phone") String phone) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.findUserByOpenId(openId);
        try {
            User updater = userService.updateUser(user, phone);
            result.put("data", updater);
            result.put("status", 200);
            result.put("msg", "绑定成功");
        } catch (Exception e) {
            result.put("data", null);
            result.put("status", 203);
            result.put("msg", "绑定失败");
        }
        return result;
    }
}
