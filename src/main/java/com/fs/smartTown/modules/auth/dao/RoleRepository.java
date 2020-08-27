package com.fs.smartTown.modules.auth.dao;

import com.fs.smartTown.modules.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{
}
