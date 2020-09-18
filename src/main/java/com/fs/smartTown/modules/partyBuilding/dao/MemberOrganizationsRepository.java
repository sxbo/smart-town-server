package com.fs.smartTown.modules.partyBuilding.dao;

import com.fs.smartTown.modules.partyBuilding.entity.MemberOrganizations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 　　* @description
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/09 4:05 下午
 *
 */
public interface MemberOrganizationsRepository extends JpaRepository<MemberOrganizations,Integer> {
    List<MemberOrganizations> findByJobType(Integer jobType);
}
