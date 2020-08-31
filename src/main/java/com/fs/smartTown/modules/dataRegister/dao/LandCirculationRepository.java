package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.LandCirculation;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 　　* @description: 土地流转
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 *
 */
public interface LandCirculationRepository extends JpaRepository<LandCirculation,Integer> {
}
