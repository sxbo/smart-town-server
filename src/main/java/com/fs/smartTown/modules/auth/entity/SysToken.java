package com.fs.smartTown.modules.auth.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class SysToken implements Serializable{
    /**
     * 用户ID
     */
    @Id
    @ApiModelProperty(value = "用户ID", example = "1")
    private Integer userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
