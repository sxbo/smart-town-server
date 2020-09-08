package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.GreenhouseRepository;
import com.fs.smartTown.modules.dataRegister.entity.Breed;
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
 * 　　* @description: 山体滑坡
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
            @ApiImplicitParam(name = "phone", value = "电话"),
            @ApiImplicitParam(name = "type", value = "类型"),
            @ApiImplicitParam(name = "name", value = "姓名"),
    })
    @ApiOperation("添加大棚数据")
    @PostMapping("/sys/greenhouse")
    public Map<String, Object> addGreenhouse(@RequestParam("manage") String manage,
                                             @RequestParam("phone") String phone,
                                             @RequestParam("type") Integer type,
                                             @RequestParam("name") String name) {
        Map<String, Object> result = new HashMap<>();
        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setManage(manage);
        greenhouse.setPhone(phone);
        greenhouse.setType(type);
        greenhouse.setName(name);
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


    /**
     * 获取大棚
     *
     * @return
     */
    @ApiOperation("查询大棚数据")
    @GetMapping("/sys/greenhouse")
    public Map<String, Object> getGreenhouse() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", greenhouseRepository.findAll());
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
    @ApiOperation("根据ID删除大棚数据")
    @DeleteMapping("/sys/greenhouse")
    public Map<String, Object> delGreenhouse(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            greenhouseRepository.deleteById(id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "操作失败");
        }
        return result;
    }


}
