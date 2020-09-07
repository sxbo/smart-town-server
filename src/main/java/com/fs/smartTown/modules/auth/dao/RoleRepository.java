package com.fs.smartTown.modules.auth.dao;

import com.fs.smartTown.modules.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    Set<Role> findAllByRoleName(String roleName);
}
