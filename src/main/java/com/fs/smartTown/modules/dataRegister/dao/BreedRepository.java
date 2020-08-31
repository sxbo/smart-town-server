package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.Breed;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 　　* @description: 养殖
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 *
 */
public interface BreedRepository extends JpaRepository<Breed,Integer> {
}
