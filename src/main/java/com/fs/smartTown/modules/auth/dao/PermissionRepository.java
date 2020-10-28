package com.fs.smartTown.modules.auth.dao;

import com.fs.smartTown.modules.auth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{
    Permission findPermissionByPermissionName(String permissionName);

    /**
     * @param permission
     * @return
     */
    Permission findPermissionByPermission(String permission);
    List<Permission> findAllByPermissionNameContainingOrPermissionContaining(String permissionName, String permission);
}
