package com.fs.smartTown.modules.auth.controller;


import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.auth.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String, Object> users(@RequestHeader("token") String token, BindingResult bindingResult){
        Map<String, Object> result = new HashMap<>();
        List<User> users = userService.getUsers();
        result.put("data", users);
        result.put("status", 200);
        return result;
    }
}
