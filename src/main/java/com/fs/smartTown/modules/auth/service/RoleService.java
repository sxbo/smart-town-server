package com.fs.smartTown.modules.auth.service;

import com.fs.smartTown.modules.auth.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    /**
     * 新建角色
     * @param role
     * @return
     */
    Role addRole(Role role);

    /**
     * 获取角色列表
     * @return
     */
    List<Role> getAllRoles ();

    /**
     * 修改角色
     * @param role
     * @return
     * @throws Exception id为空
     */
    Role updateRole(Role role) throws Exception;

    /**
     * 删除角色
     * @param
     * @return
     */
    void deleteRole(Integer roleId);
    Set<Role> findRolesByRoleName(String roleName);
    Set<Role> findAllByIds(List<Integer> roleIds);
}
