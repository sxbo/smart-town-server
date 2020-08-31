package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 　　* @description: 大棚
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 *
 */
public interface GreenhouseRepository extends JpaRepository<Greenhouse,Integer> {
}
