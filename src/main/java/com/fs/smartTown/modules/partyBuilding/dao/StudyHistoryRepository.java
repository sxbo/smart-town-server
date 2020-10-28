package com.fs.smartTown.modules.partyBuilding.dao;

import com.fs.smartTown.modules.partyBuilding.entity.GiveUp;
import com.fs.smartTown.modules.partyBuilding.entity.StudyInHistory;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 　　* @description
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/09 4:05 下午
 *
 */
public interface StudyHistoryRepository extends JpaRepository<StudyInHistory,Integer> {

    StudyInHistory findByStudyId(Integer studyId);

    List<StudyInHistory> findByUserId(Integer userId, Sort sort);
}
