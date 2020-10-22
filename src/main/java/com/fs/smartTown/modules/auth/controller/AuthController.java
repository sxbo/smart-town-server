package com.fs.smartTown.modules.auth.controller;


import com.fs.smartTown.modules.auth.DTO.LoginDTO;
import com.fs.smartTown.modules.auth.entity.SysToken;
import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.auth.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;


@Api(tags = "登录认证")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 登录
     */
    @ApiOperation(value = "登陆", notes = "参数:用户名 密码")
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody @Validated LoginDTO loginDTO, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        if (bindingResult.hasErrors()) {
            result.put("status", 400);
            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        //用户信息
        User user = authService.findByUsername(username);
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(password)) {
            result.put("status", 400);
            result.put("msg", "账号或密码有误");
        } else {
            //生成token，并保存到数据库
            result = authService.createToken(user.getUserId());
            result.put("status", 200);
            result.put("msg", "登陆成功");
            user.setPassword(null);
            result.put("data", user);
        }
        return result;
    }

    /**
     * 退出
     */
    @ApiOperation(value = "登出", notes = "参数:token")
    @PostMapping("/sys/logout")
    public Map<String, Object> logout(@RequestHeader("token") String token) {
        Map<String, Object> result = new HashMap<>();
        SysToken sysToken = authService.logout(token);
        if (sysToken != null) {
            result.put("data", sysToken);
            result.put("status", 200);
            result.put("msg", "您已安全退出系统");
        } else {
            result.put("status", 203);
            result.put("msg", "退出系统失败");
        }
        return result;
    }

}
