package com.fs.smartTown.modules.auth.DTO;
import com.fs.smartTown.modules.auth.entity.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
public class UserDto {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "电话不能为空")
    private String phone;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "角色不能为空")
    private List<Role> roles;
}

