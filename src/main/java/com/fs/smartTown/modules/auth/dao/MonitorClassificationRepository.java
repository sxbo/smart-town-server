package com.fs.smartTown.modules.auth.dao;

import com.fs.smartTown.modules.auth.entity.MonitorClassification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonitorClassificationRepository extends JpaRepository<MonitorClassification, Integer> {
    List<MonitorClassification> findByMonitorType(Integer monitorType);
}
