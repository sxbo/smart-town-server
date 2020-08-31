package com.fs.smartTown.modules.auth.controller;


import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.auth.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户管理apis")
@RestController("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "获取用户列表", tags = "user")
    @GetMapping("/list")
    public Map<String, Object> users(){
        Map<String, Object> result = new HashMap<>();
        List<User> users = userService.getUsers();
        result.put("data", users);
        result.put("status", 200);
        return result;
    }

    @ApiOperation(value = "添加用户")
    @RequiresPermissions("user:add")
    @RequiresRoles("sysManager")
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
}
