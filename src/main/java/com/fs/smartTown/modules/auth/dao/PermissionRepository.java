package com.fs.smartTown.modules.auth.dao;

import com.fs.smartTown.modules.auth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{
}
