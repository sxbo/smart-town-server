package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.PovertyAlleviationRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 　　* @description: 精准扶贫
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 */
public interface PovertyAlleviationRecordRepository extends JpaRepository<PovertyAlleviationRecord, Integer> {
    List<PovertyAlleviationRecord> findByHelpProjectLike(String helpProject);
}
