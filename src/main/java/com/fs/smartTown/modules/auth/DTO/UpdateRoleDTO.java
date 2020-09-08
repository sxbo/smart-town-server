package com.fs.smartTown.modules.auth.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UpdateRoleDTO {
    @NotBlank(message = "用户id不能为空")
    private Integer userId;

    @NotBlank(message = "角色id不能为空")
    private List<Integer> roleIds;
}
