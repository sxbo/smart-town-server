package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.LandCirculation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 　　* @description: 土地流转
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 *
 */
public interface LandCirculationRepository extends JpaRepository<LandCirculation,Integer> {
    @Query(value = "select * from land_circulation where if(?1 !='',outflow_side=?1,1=1) and if(?2 !='',inflow_side=?2,1=1) and if(?3 !='',location=?3,1=1) ", nativeQuery = true)
    List<LandCirculation> filterLandCirculation(String outflowSide, String inflowSide, String location);
}
