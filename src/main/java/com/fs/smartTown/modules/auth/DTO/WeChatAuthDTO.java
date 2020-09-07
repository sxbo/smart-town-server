package com.fs.smartTown.modules.auth.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class WeChatAuthDTO {
    @NotBlank(message = "用户名不能为空")
    private String openId;

    @NotBlank(message = "昵称不能为空")
    private String nickName;
}

