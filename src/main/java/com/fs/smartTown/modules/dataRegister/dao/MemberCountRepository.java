package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.MemberCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCountRepository extends JpaRepository<MemberCount, Integer>{
}
