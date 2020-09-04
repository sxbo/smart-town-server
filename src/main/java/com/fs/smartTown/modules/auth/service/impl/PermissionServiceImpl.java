package com.fs.smartTown.modules.auth.service.impl;

import com.fs.smartTown.modules.auth.dao.PermissionRepository;
import com.fs.smartTown.modules.auth.entity.Permission;
import com.fs.smartTown.modules.auth.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Permission addPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> getAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission updatePermission(Permission permission) throws Exception {
        if (permission.getPermissionId() == null){
            throw new Exception("异常：权限id为空！");
        }
        return permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(Integer permissionId) {
        permissionRepository.deleteById(permissionId);
    }
}
