package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.ScreenMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScreenMonitorRepository extends JpaRepository<ScreenMonitor, Integer>{
    @Query(value = "select * from screen_monitor", nativeQuery = true)
    List<ScreenMonitor> getAllScreenMonitor();
}
