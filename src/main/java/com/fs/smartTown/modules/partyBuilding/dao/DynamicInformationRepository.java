package com.fs.smartTown.modules.partyBuilding.dao;

import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.partyBuilding.entity.DynamicInformation;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 　　* @description
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/09 4:05 下午
 */
public interface DynamicInformationRepository extends JpaRepository<DynamicInformation, Integer> {

    List<DynamicInformation> findAllByTypeId(Integer type,Sort sort);
    List<DynamicInformation> findAllByTypeId(Integer typ, Pageable pageable);


}
