package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.BreedRepository;
import com.fs.smartTown.modules.dataRegister.dao.GreenhouseRepository;
import com.fs.smartTown.modules.dataRegister.entity.Breed;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;

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
 * 　　* @description: 养殖
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "养殖")
@RestController
public class BreedController {

    @Autowired
    private BreedRepository breedRepository;

    /**
     * 添加大棚登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manage", value = "管理者"),
            @ApiImplicitParam(name = "phone", value = "电话"),
            @ApiImplicitParam(name = "type", value = "类型"),
            @ApiImplicitParam(name = "name", value = "姓名"),
            @ApiImplicitParam(name = "tradingVolume", value = "交易量"),
            @ApiImplicitParam(name = "turnover", value = "交易额"),
    })
    @PostMapping("/sys/breed")
    public Map<String, Object> addScenicSpot(@RequestParam("manage") String manage,
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
        Breed breedResult = breedRepository.save(breed);
        if (breedResult != null) {
            result.put("status", 200);
            result.put("msg", "添加成功");
        } else {
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }


}
