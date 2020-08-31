package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.ScenicSpotRepository;
import com.fs.smartTown.modules.dataRegister.entity.PovertyAlleviationRecord;
import com.fs.smartTown.modules.dataRegister.entity.ScenicSpot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/sys/scenicSpot")
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
        ScenicSpot scenicSpotResult = scenicSpotRepository.save(scenicSpot);
        if (scenicSpotResult != null) {
            result.put("status", 200);
            result.put("msg", "添加成功");
        } else {
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }

    /**
     * 获取景区流量
     *
     * @return
     */
    @ApiOperation("查询景区流量数据")
    @GetMapping("/sys/scenicSpot")
    public List<ScenicSpot> getScenicSpot() {
        return scenicSpotRepository.findAll();
    }

    /**
     * 根据ID删除数据
     *
     * @return
     */
    @ApiOperation("根据ID删除景区流量数据")
    @DeleteMapping("/sys/scenicSpot")
    public Map<String, Object> delScenicSpot(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        scenicSpotRepository.deleteById(id);
        result.put("status", 200);
        result.put("msg", "删除成功");
        return result;
    }


}
