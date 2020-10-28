package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.Poor;
import com.fs.smartTown.modules.dataRegister.entity.ScenicSpot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 *
 */
public interface PoorRepository extends JpaRepository<Poor,Integer> {


    @Query(value = "select * from poor_users where if(?1 !='',name=?1,1=1) and if(?2 !='',village=?2,1=1) and if(?3 !='',idCard=?3,1=1) ", nativeQuery = true)
    List<Poor> findByPoorList(String name, String village, String idCard);
}
