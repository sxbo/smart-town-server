package com.fs.smartTown.modules.auth.service.impl;

import com.fs.smartTown.modules.auth.dao.RoleRepository;
import com.fs.smartTown.modules.auth.entity.Role;
import com.fs.smartTown.modules.auth.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
