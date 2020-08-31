package com.fs.smartTown.modules.auth.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Permission {

    @Id
    @ApiModelProperty(value = "权限ID", example = "1")
    private Integer permissionId;
    //权限描述
    private String permissionName;
    private String permission;
}
