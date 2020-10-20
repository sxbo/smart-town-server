package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.ConvenientService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


/**
 * 　　* @description: 便民服务
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 4:05 下午
 */
public interface ConvenientServiceRepository extends JpaRepository<ConvenientService, Integer> {

    @Query(value = "select * from bm_convenient_service where if(?1 !='',user_id=?1,1=1) and if(?2 !='',state=?2,1=1) and if(?3 !='',is_delete=?3,1=1) ", nativeQuery = true)
    List<ConvenientService> findConvenientServiceList(Integer userId, Integer state,Integer isDelete);

    ConvenientService findByBmId(Integer bmId);
    @Query(value = "select * from bm_convenient_service where if(?1 !='',type=?1,1=1) and if(?2 !='',state=?2,1=1) ", nativeQuery = true)
    List<ConvenientService> findAllByTypeAndState(Integer type, Integer state);
}
