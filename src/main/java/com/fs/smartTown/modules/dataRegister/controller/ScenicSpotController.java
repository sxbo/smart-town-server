package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.ScenicSpotRepository;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;
import com.fs.smartTown.modules.dataRegister.entity.PovertyAlleviationRecord;
import com.fs.smartTown.modules.dataRegister.entity.ScenicSpot;

import org.springframework.beans.factory.annotation.Autowired;
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
 * 　　* @description: 景区流量
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "景区流量")
@RestController
public class ScenicSpotController {

    @Autowired
    private ScenicSpotRepository scenicSpotRepository;

    /**
     * 添加景区流量登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "scenicspotName", value = "景点名称"),
            @ApiImplicitParam(name = "address", value = "地址"),
            @ApiImplicitParam(name = "personCharge", value = "负责人"),
            @ApiImplicitParam(name = "personPhone", value = "负责人电话"),
    })
    @ApiOperation("添加景区流量数据")
    @PostMapping("/scenicSpot")
    public Map<String, Object> addScenicSpot(@RequestParam("scenicspotName") String scenicspotName,
                                             @RequestParam("address") String address,
                                             @RequestParam("personCharge") String personCharge,
                                             @RequestParam("personPhone") String personPhone) {
        Map<String, Object> result = new HashMap<>();
        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setScenicspotName(scenicspotName);
        scenicSpot.setAddress(address);
        scenicSpot.setPersonCharge(personCharge);
        scenicSpot.setPersonPhone(personPhone);
        scenicSpot.setAlarmNum(0);
        scenicSpot.setCreateTime(new Date());
        try {
            scenicSpotRepository.save(scenicSpot);
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("添加景区流量数据")
    @PostMapping("/addScenicSpot")
    public Map<String, Object> addScenicSpot(@RequestBody ScenicSpot scenicSpot) {
        Map<String, Object> result = new HashMap<>();
        try {
            scenicSpot.setCreateTime(new Date());
            scenicSpot.setAlarmNum(0);
            result.put("data", scenicSpotRepository.save(scenicSpot));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新景区流量数据")
    @PutMapping("/updateScenicSpot")
    public Map<String, Object> updateScenicSpot(@RequestBody ScenicSpot scenicSpot) {
        Map<String, Object> result = new HashMap<>();
        try {
            scenicSpot.setCreateTime(new Date());
            result.put("data", scenicSpotRepository.save(scenicSpot));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }

    /**
     * 获取景区流量
     *
     * @return
     */
    @ApiOperation("查询景区流量数据")
    @GetMapping("/scenicSpot")
    public Map<String, Object> getScenicSpot() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", scenicSpotRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime")));
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
    @ApiOperation("根据ID删除景区流量数据")
    @DeleteMapping("/scenicSpot/{id}")
    public Map<String, Object> delScenicSpot(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            scenicSpotRepository.deleteById(id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "操作失败");
        }

        return result;
    }
}
