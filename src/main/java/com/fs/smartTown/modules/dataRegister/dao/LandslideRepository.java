package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.Landslide;
import com.fs.smartTown.modules.dataRegister.entity.ScenicSpot;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 　　* @description: 山体滑坡
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 *
 */
public interface LandslideRepository extends JpaRepository<Landslide,Integer> {
}
