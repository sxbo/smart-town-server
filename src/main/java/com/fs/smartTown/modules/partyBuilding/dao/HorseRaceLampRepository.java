package com.fs.smartTown.modules.partyBuilding.dao;

import com.fs.smartTown.modules.partyBuilding.entity.DynamicInformation;
import com.fs.smartTown.modules.partyBuilding.entity.HorseRaceLamp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 　　* @description
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/09 4:05 下午
 *
 */
public interface HorseRaceLampRepository extends JpaRepository<HorseRaceLamp,Integer> {
    List<HorseRaceLamp> findByType(Integer type);
}
