package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.ScenicSpot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 　　* @description: 景区流量
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 *
 */
public interface ScenicSpotRepository extends JpaRepository<ScenicSpot,Integer> {

    @Query(value = "select * from scenic_spot where if(?1 !='',scenicspotName=?1,1=1) and if(?2 !='',address=?2,1=1) and if(?3 !='',personCharge=?3,1=1) ", nativeQuery = true)
    List<ScenicSpot> findByScenicSpotList(String scenicspotName, String address, String personCharge);
}
