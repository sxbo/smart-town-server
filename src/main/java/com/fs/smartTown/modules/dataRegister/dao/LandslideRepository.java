package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.Landslide;
import com.fs.smartTown.modules.dataRegister.entity.ScenicSpot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 　　* @description: 山体滑坡
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 */
public interface LandslideRepository extends JpaRepository<Landslide, Integer> {

    @Query(value = "select * from landslide where if(?1 !='',address=?1,1=1) and if(?2 !='',personCharge=?2,1=1) ", nativeQuery = true)
    List<Landslide> findByLandslideList(String address, String personCharge);
}
