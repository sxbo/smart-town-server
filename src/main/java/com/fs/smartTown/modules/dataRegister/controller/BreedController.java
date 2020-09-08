package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.BreedRepository;
import com.fs.smartTown.modules.dataRegister.dao.GreenhouseRepository;
import com.fs.smartTown.modules.dataRegister.entity.Breed;
import com.fs.smartTown.modules.dataRegister.entity.EpidemicSurveillance;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;

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
 * 　　* @description: 养殖
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "水产养殖")
@RestController
public class BreedController {

    @Autowired
    private BreedRepository breedRepository;

    /**
     * 添加养殖登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manage", value = "管理者"),
            @ApiImplicitParam(name = "phone", value = "电话"),
            @ApiImplicitParam(name = "type", value = "类型"),
            @ApiImplicitParam(name = "name", value = "姓名"),
            @ApiImplicitParam(name = "tradingVolume", value = "交易量"),
            @ApiImplicitParam(name = "turnover", value = "交易额"),
    })
    @ApiOperation("添加养殖数据")
    @PostMapping("/sys/breed")
    public Map<String, Object> addBreed(@RequestParam("manage") String manage,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("type") Integer type,
                                        @RequestParam("name") String name,
                                        @RequestParam("tradingVolume") String tradingVolume,
                                        @RequestParam("turnover") String turnover) {
        Map<String, Object> result = new HashMap<>();
        Breed breed = new Breed();
        breed.setManage(manage);
        breed.setPhone(phone);
        breed.setType(type);
        breed.setName(name);
        breed.setTradingVolume(tradingVolume);
        breed.setTurnover(turnover);
        try {
            breedRepository.save(breed);
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    /**
     * 获取养殖数据
     *
     * @return
     */
    @ApiOperation("查询养殖数据")
    @GetMapping("/sys/breed")
    public Map<String, Object> getBreed() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", breedRepository.findAll());
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
    @ApiOperation("根据ID删除养殖数据")
    @DeleteMapping("/sys/breed")
    public Map<String, Object> delBreed(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            breedRepository.deleteById(id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "操作失败");
        }
        return result;
    }


}
