package com.fs.smartTown.modules.auth.controller;


import com.fs.smartTown.modules.auth.DTO.UpdateRoleDTO;
import com.fs.smartTown.modules.auth.DTO.WeChatAuthDTO;
import com.fs.smartTown.modules.auth.entity.Role;
import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.auth.service.RoleService;
import com.fs.smartTown.modules.auth.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.RandomStringUtils;
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
    public Map<String, Object> users(){
        Map<String, Object> result = new HashMap<>();
        List<User> users = userService.getUsers();
        result.put("data", users);
        result.put("status", 200);
        return result;
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("")
    public Map<String, Object> add(@RequestBody User user){
        Map<String, Object> result = new HashMap<>();
        try {
            User addedUser =  userService.addUser(user);
            result.put("data", addedUser);
            result.put("status", 200);
            result.put("msg", "添加成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }

    @ApiOperation(value = "跟新用户")
    @PutMapping("")
    public Map<String, Object> update(@RequestBody User user){
        Map<String, Object> result = new HashMap<>();
        try {
            User updater =  userService.updateUser(user);
            result.put("data", updater);
            result.put("status", 200);
            result.put("msg", "添加成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("")
    public Map<String, Object> deleteUser(@PathVariable Integer userId){
        Map<String, Object> result = new HashMap<>();
        try {
            userService.deleteUser(userId);
            result.put("data", userId);
            result.put("status", 200);
            result.put("msg", "删除成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "操作失败");
        }
        return result;
    }

    @ApiOperation(value = "微信用户认证")
    @PostMapping("/wx_auth")
    public Map<String, Object> weChantAuth(@RequestBody WeChatAuthDTO weChatAuthDTO, BindingResult bindingResult){
        Map<String, Object> result = new HashMap<>();
        //DTO提示信息绑定
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            User user =  userService.findUserByOpenId(weChatAuthDTO.getOpenId());
            //不是第一次登陆，直接返回用户信息
            if (user != null){
                result.put("data", user);
                result.put("status", 200);
                result.put("msg", "获取用户信息成功！");
            //第一次登陆，先保存后返回
            } else {
                //默认密码
                String defaultPass = RandomStringUtils.random(8, "abcdefghijklmnopqrstuvwxyz1234567890");
                user.setPassword(defaultPass);
                user.setUsername(weChatAuthDTO.getNickName());
                Date date = new Date();
                user.setCreateTime(date);
                user.setUpdateTime(date);
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
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "获取用户信息失败！");
        }
        return result;
    }

    @ApiOperation(value = "设置用户角色: 参数：userId， roleIds")
    @PostMapping("/update_role")
    public Map<String, Object> setRolesByUserIdAndRoleIds(@RequestBody UpdateRoleDTO updateRoleDTO, BindingResult bindingResult){
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            User user =  userService.findUserByUserId(updateRoleDTO.getUserId());
            List<Integer> roleIds = updateRoleDTO.getRoleIds();
            Set<Role> roles = roleService.findAllByIds(roleIds);
            user.setRoles(roles);
            userService.updateUser(user);
            result.put("data", user);
            result.put("status", 200);
            result.put("msg", "设置角色成功！");

        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "设置角色失败！");
        }
        return result;
    }
}
