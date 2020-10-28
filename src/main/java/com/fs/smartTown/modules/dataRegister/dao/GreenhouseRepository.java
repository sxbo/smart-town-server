package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 　　* @description: 大棚
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 */
public interface GreenhouseRepository extends JpaRepository<Greenhouse, Integer> {


    @Query(value = "select * from greenhouse where if(?1 !='',name=?1,1=1) and if(?2 !='',address=?2,1=1) and if(?3 !='',manage=?3,1=1) ", nativeQuery = true)
    List<Greenhouse> findByGreenhouseList(String name, String address, String manage);
}
