package com.fs.smartTown.modules.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Permission {

    @Id
    private Integer permissionId;
    //权限描述
    private String permissionName;
    private String permission;
}
