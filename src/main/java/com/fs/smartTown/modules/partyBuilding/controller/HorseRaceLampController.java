package com.fs.smartTown.modules.partyBuilding.controller;

import com.fs.smartTown.modules.partyBuilding.dao.DynamicInformationRepository;
import com.fs.smartTown.modules.partyBuilding.dao.HorseRaceLampRepository;
import com.fs.smartTown.modules.partyBuilding.entity.DynamicInformation;
import com.fs.smartTown.modules.partyBuilding.entity.HorseRaceLamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 *
 */
@Api(tags = "跑马灯")
@RestController
public class HorseRaceLampController {

    @Autowired
    private HorseRaceLampRepository horseRaceLampRepository;


    @ApiOperation("添加跑马灯消息")
    @PostMapping("/spb/addHorseRaceLamp")
    public Map<String, Object> addHorseRaceLamp(@RequestBody HorseRaceLamp horseRaceLamp) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("查询跑马灯消息")
    @GetMapping("/spb/getHorseRaceLamp")
    public Map<String, Object> getHorseRaceLamp() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", horseRaceLampRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("更新跑马灯消息")
    @PutMapping("/spb/updateHorseRaceLamp")
    public Map<String, Object> updateHorseRaceLamp(@RequestBody HorseRaceLamp horseRaceLamp) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("根据ID删除跑马灯消息")
    @DeleteMapping("/spb/delHorseRaceLamp")
    public Map<String, Object> delHorseRaceLamp(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }

}
