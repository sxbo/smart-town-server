package com.fs.smartTown.modules.partyBuilding.dao;

import com.fs.smartTown.modules.partyBuilding.entity.DynamicInformation;
import com.fs.smartTown.modules.partyBuilding.entity.GiveUp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 　　* @description
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/09 4:05 下午
 *
 */
public interface DynamicInformationRepository extends JpaRepository<DynamicInformation,Integer> {
    List<DynamicInformation> findByType(Integer type);

}
