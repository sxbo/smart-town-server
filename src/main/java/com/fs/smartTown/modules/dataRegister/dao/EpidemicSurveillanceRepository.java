package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.Breed;
import com.fs.smartTown.modules.dataRegister.entity.EpidemicSurveillance;

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
public interface EpidemicSurveillanceRepository extends JpaRepository<EpidemicSurveillance,Integer> {


    @Query(value = "select * from epidemic_surveillance where if(?1 !='',name=?1,1=1) and if(?2 !='',idCard=?2,1=1) and if(?3 !='',state=?3,1=1) ", nativeQuery = true)
    List<EpidemicSurveillance> findByEpidemicSurveillanceList(String name, String idCard, Integer state);
}
