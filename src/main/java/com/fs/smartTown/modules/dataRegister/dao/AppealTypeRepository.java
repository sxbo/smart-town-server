package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.AppealType;
import com.fs.smartTown.modules.dataRegister.entity.Breed;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 　　* @description:  便民服务类型
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 *
 */
public interface AppealTypeRepository extends JpaRepository<AppealType,Integer> {
}
