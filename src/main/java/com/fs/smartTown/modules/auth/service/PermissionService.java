package com.fs.smartTown.modules.auth.service;

import com.fs.smartTown.modules.auth.entity.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 新建权限
     * @param permission
     * @return
     */
    Permission addPermission(Permission permission);

    /**
     * 获取权限列表
     * @return
     */
    List<Permission> getAllPermission ();

    /**
     * 修改角色
     * @param permission
     * @return
     * @throws Exception id为空
     */
    Permission updatePermission(Permission permission) throws Exception;

    /**
     * 删除角色
     * @param
     * @return
     */
    void deletePermission(Integer roleId);
}
