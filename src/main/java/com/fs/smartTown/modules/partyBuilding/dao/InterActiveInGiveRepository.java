package com.fs.smartTown.modules.partyBuilding.dao;

import com.fs.smartTown.modules.partyBuilding.entity.GiveUp;
import com.fs.smartTown.modules.partyBuilding.entity.InterActiveInformation;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 　　* @description
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/09 4:05 下午
 *
 */
public interface InterActiveInGiveRepository extends JpaRepository<GiveUp,Integer> {

    GiveUp findByBbsId(Integer bbsId);
}
