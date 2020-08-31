package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.PovertyAlleviationRecordRepository;
import com.fs.smartTown.modules.dataRegister.entity.PovertyAlleviationRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

/**
 * 　　* @description: 精准扶贫
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "精准扶贫")
@RestController
public class PovertyAlleviationRecordController {

    @Autowired
    private PovertyAlleviationRecordRepository povertyAlleviationRecordRepository;

    /**
     * 添加精准扶贫登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "helpObj", value = "帮扶对象"),
            @ApiImplicitParam(name = "village", value = "所属村"),
            @ApiImplicitParam(name = "personCharge", value = "负责人"),
            @ApiImplicitParam(name = "helpProject", value = "帮扶项目"),
            @ApiImplicitParam(name = "createTime", value = "帮扶时间"),
            @ApiImplicitParam(name = "poorState", value = "贫困状态"),
            @ApiImplicitParam(name = "helpum", value = "帮扶数量"),
    })
    @PostMapping("/sys/povertyAlleviationRecord")
    public Map<String, Object> addPovertyAlleviationRecord(@RequestParam("helpObj") String helpObj,
                                                           @RequestParam("village") String village,
                                                           @RequestParam("personCharge") String personCharge,
                                                           @RequestParam("helpProject") String helpProject,
                                                           @RequestParam("createTime") String createTime,
                                                           @RequestParam("poorState") Integer poorState,
                                                           @RequestParam("helpNum") Integer helpNum) {
        Map<String, Object> result = new HashMap<>();
        PovertyAlleviationRecord povertyAlleviationRecord = new PovertyAlleviationRecord();
        povertyAlleviationRecord.setHelpObj(helpObj);
        povertyAlleviationRecord.setVillage(village);
        povertyAlleviationRecord.setPersonCharge(personCharge);
        povertyAlleviationRecord.setHelpProject(helpProject);
        povertyAlleviationRecord.setCreateTime(createTime);
        povertyAlleviationRecord.setPoorState(poorState);
        povertyAlleviationRecord.setHelpNum(helpNum);
        PovertyAlleviationRecord alleviationRecord = povertyAlleviationRecordRepository.save(povertyAlleviationRecord);
        if (alleviationRecord != null) {
            result.put("status", 200);
            result.put("msg", "添加成功");
        } else {
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }

}
