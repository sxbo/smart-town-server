package com.fs.smartTown.modules.partyBuilding.dao;

import com.fs.smartTown.modules.partyBuilding.entity.Advertisement;
import com.fs.smartTown.modules.partyBuilding.entity.DynamicInformation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 　　* @description
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/09 4:05 下午
 *
 */
public interface AdvertisementRepository extends JpaRepository<Advertisement,Integer> {

    List<Advertisement> findByType(Integer type);
}
