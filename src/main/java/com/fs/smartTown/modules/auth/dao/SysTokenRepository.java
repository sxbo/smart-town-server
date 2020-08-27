package com.fs.smartTown.modules.auth.dao;

import com.fs.smartTown.modules.auth.entity.SysToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysTokenRepository extends JpaRepository<SysToken, Integer>{

    /**
     * 通过token查找
     * @param token
     * @return
     */
    SysToken findByToken(String token);

    /**
     * 通过userID查找
     * @param userId
     * @return
     */
    SysToken findByUserId(Integer userId);
}
