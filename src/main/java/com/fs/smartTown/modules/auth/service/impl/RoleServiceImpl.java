package com.fs.smartTown.modules.auth.service.impl;

import com.fs.smartTown.modules.auth.dao.RoleRepository;
import com.fs.smartTown.modules.auth.entity.Role;
import com.fs.smartTown.modules.auth.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @Override
    public Role updateRole(Role role) throws Exception {
        if (role.getRoleId() == null){
            throw new Exception("异常：roleId为空！");
        }
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Integer roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public Set<Role> findRolesByRoleName(String roleName) {
        Set<Role> roles =  roleRepository.findAllByRoleName(roleName);
        return roles;
    }

    @Override
    public Set<Role> findAllByIds(List<Integer> roleIds){
        Iterable<Integer> iterable = roleIds;
        List<Role> roles = roleRepository.findAllById(iterable);
        Set<Role> roleSet = new HashSet<Role>(roles);
        return roleSet;
    }
}
