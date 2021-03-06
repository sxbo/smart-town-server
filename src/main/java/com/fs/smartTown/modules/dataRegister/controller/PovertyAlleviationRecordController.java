package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.PovertyAlleviationRecordRepository;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;
import com.fs.smartTown.modules.dataRegister.entity.PovertyAlleviationRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
            @ApiImplicitParam(name = "poorState", value = "贫困状态"),
            @ApiImplicitParam(name = "poorYear", value = "贫困年度"),
    })
    @ApiOperation("添加精准扶贫数据")
    @PostMapping("/povertyAlleviationRecord")
    public Map<String, Object> addPovertyAlleviationRecord(@RequestParam("helpObj") String helpObj,
                                                           @RequestParam("village") String village,
                                                           @RequestParam("personCharge") String personCharge,
                                                           @RequestParam("helpProject") String helpProject,
                                                           @RequestParam("poorState") Integer poorState,
                                                           @RequestParam("poorYear") String poorYear) {
        Map<String, Object> result = new HashMap<>();
        PovertyAlleviationRecord povertyAlleviationRecord = new PovertyAlleviationRecord();
        povertyAlleviationRecord.setHelpObj(helpObj);
        povertyAlleviationRecord.setVillage(village);
        povertyAlleviationRecord.setPersonCharge(personCharge);
        povertyAlleviationRecord.setHelpProject(helpProject);
        povertyAlleviationRecord.setCreateTime(new Date());
        povertyAlleviationRecord.setPoorState(poorState);
        povertyAlleviationRecord.setPoorYear(poorYear);
        try {
            povertyAlleviationRecordRepository.save(povertyAlleviationRecord);
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("添加精准扶贫数据")
    @PostMapping("/addGreenhaddPovertyAlleviationRecordouse")
    public Map<String, Object> addPovertyAlleviationRecord(@RequestBody PovertyAlleviationRecord povertyAlleviationRecord) {
        Map<String, Object> result = new HashMap<>();
        try {
            povertyAlleviationRecord.setCreateTime(new Date());
            result.put("data", povertyAlleviationRecordRepository.save(povertyAlleviationRecord));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新精准扶贫数据")
    @PutMapping("/updatePovertyAlleviationRecord")
    public Map<String, Object> updatePovertyAlleviationRecord(@RequestBody PovertyAlleviationRecord povertyAlleviationRecord) {
        Map<String, Object> result = new HashMap<>();
        try {
            povertyAlleviationRecord.setCreateTime(new Date());
            result.put("data", povertyAlleviationRecordRepository.save(povertyAlleviationRecord));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }

    @ApiOperation("查询精准扶贫数据:贫困对象、负责人")
    @GetMapping("/findByPovertyAlleviationRecordHistoryList")
    public Map<String, Object> findByPovertyAlleviationRecordHistoryList(@RequestParam("helpObj") String helpObj,
                                                                  @RequestParam("personCharge") String personCharge) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", povertyAlleviationRecordRepository.findByPovertyAlleviationRecordHistoryList(helpObj, personCharge));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    /**
     * 获取精准扶贫
     *
     * @return
     */
    @ApiOperation("查询精准扶贫数据")
    @GetMapping("/povertyAlleviationRecord")
    public Map<String, Object> getPovertyAlleviationRecord() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", povertyAlleviationRecordRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime")));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询精准扶贫数据分页")
    @GetMapping("/povertyAlleviationRecordPage")
    public Map<String, Object> getPovertyAlleviationRecordPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        Map<String, Object> result = new HashMap<>();
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
            result.put("data", povertyAlleviationRecordRepository.findAll(pageable));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    /**
     * 根据关键字搜索精准扶贫
     *
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "helpProject", value = "帮扶项目")
    })
    @ApiOperation("搜索查询精准扶贫数据")
    @GetMapping("/searchPovertyAlleviationRecord")
    public Map<String, Object> searchPovertyAlleviationRecord(@RequestParam("helpProject") String helpProject) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", povertyAlleviationRecordRepository.findByHelpProjectLike("%" + helpProject + "%"));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }

        return result;
    }

    /**
     * 根据ID删除数据
     *
     * @return
     */
    @ApiOperation("根据ID删除精准扶贫数据")
    @DeleteMapping("/povertyAlleviationRecord/{id}")
    public Map<String, Object> delPovertyAlleviationRecord(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            povertyAlleviationRecordRepository.deleteById(id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "操作失败");
            e.printStackTrace();
        }
        return result;
    }
}
