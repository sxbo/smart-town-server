package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.GreenhouseRepository;
import com.fs.smartTown.modules.dataRegister.entity.Breed;
import com.fs.smartTown.modules.dataRegister.entity.EpidemicSurveillance;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;

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
 * 　　* @description: 温室大棚
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "温室大棚")
@RestController
public class GreenhouseController {

    @Autowired
    private GreenhouseRepository greenhouseRepository;

    /**
     * 添加大棚登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manage", value = "管理者"),
            @ApiImplicitParam(name = "address", value = "地址"),
            @ApiImplicitParam(name = "type", value = "类型"),
            @ApiImplicitParam(name = "name", value = "名称"),
    })
    @ApiOperation("添加温室大棚数据")
    @PostMapping("/greenhouse")
    public Map<String, Object> addGreenhouse(@RequestParam("manage") String manage,
                                             @RequestParam("address") String address,
                                             @RequestParam("type") String type,
                                             @RequestParam("name") String name) {
        Map<String, Object> result = new HashMap<>();
        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setManage(manage);
        greenhouse.setAddress(address);
        greenhouse.setType(type);
        greenhouse.setName(name);
        greenhouse.setMonitorNum(0);
        greenhouse.setCreateTime(new Date());
        try {
            greenhouseRepository.save(greenhouse);
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("添加温室大棚数据")
    @PostMapping("/addGreenhouse")
    public Map<String, Object> addGreenhouse(@RequestBody Greenhouse greenhouse) {
        Map<String, Object> result = new HashMap<>();
        greenhouse.setMonitorNum(0);
        greenhouse.setCreateTime(new Date());
        try {
            result.put("data", greenhouseRepository.save(greenhouse));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新温室大棚数据")
    @PutMapping("/updateGreenhouse")
    public Map<String, Object> updateGreenhouse(@RequestBody Greenhouse greenhouse) {
        Map<String, Object> result = new HashMap<>();
        try {
            greenhouse.setCreateTime(new Date());
            result.put("data", greenhouseRepository.save(greenhouse));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }

    /**
     * 获取大棚
     *
     * @return
     */
    @ApiOperation("查询温室大棚数据")
    @GetMapping("/greenhouse")
    public Map<String, Object> getGreenhouse() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", greenhouseRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime")));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询温室大棚数据:名称、地址、管理者")
    @GetMapping("/findByGreenhouseList")
    public Map<String, Object> findByGreenhouseList(@RequestParam("name") String name,
                                                    @RequestParam("address") String address,
                                                    @RequestParam("manage") String manage) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", greenhouseRepository.findByGreenhouseList(name, address, manage));
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
    @ApiOperation("根据ID删除温室大棚数据")
    @DeleteMapping("/greenhouse/{id}")
    public Map<String, Object> delGreenhouse(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            greenhouseRepository.deleteById(id);
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
