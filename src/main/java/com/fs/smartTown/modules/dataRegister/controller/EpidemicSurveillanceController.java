package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.EpidemicSurveillanceRepository;
import com.fs.smartTown.modules.dataRegister.entity.Breed;
import com.fs.smartTown.modules.dataRegister.entity.EpidemicSurveillance;

import org.springframework.beans.factory.annotation.Autowired;
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
 * 　　* @description: 疫情防控
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "疫情防控")
@RestController
public class EpidemicSurveillanceController {

    @Autowired
    private EpidemicSurveillanceRepository epidemicSurveillanceRepository;

    /**
     * 添加防控登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名"),
            @ApiImplicitParam(name = "idCard", value = "身份证"),
            @ApiImplicitParam(name = "village", value = "所属村"),
            @ApiImplicitParam(name = "createTime", value = "登记时间"),
            @ApiImplicitParam(name = "state", value = "状态"),
            @ApiImplicitParam(name = "sexType", value = "性别"),
    })
    @ApiOperation("添加防控数据")
    @PostMapping("/epidemicSurveillance")
    public Map<String, Object> addEpidemicSurveillance(@RequestParam("name") String name,
                                                       @RequestParam("idCard") String idCard,
                                                       @RequestParam("village") String village,
                                                       @RequestParam("state") Integer state,
                                                       @RequestParam("sexType") Integer sexType) {
        Map<String, Object> result = new HashMap<>();
        EpidemicSurveillance epidemicSurveillance = new EpidemicSurveillance();
        epidemicSurveillance.setName(name);
        epidemicSurveillance.setIdCard(idCard);
        epidemicSurveillance.setVillage(village);
        epidemicSurveillance.setCreateTime(new Date());
        epidemicSurveillance.setState(state);
        epidemicSurveillance.setSexType(sexType);
        try {
            epidemicSurveillanceRepository.save(epidemicSurveillance);
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }

    /**
     * 编辑疫情数据
     *
     * @return
     */
    @ApiOperation("编辑疫情数据")
    @PutMapping ("/editEpidemicSurveillance")
    public Map<String, Object> editEpidemicSurveillance(@RequestBody() EpidemicSurveillance epidemic) {
        Map<String, Object> result = new HashMap<>();
        try {
            epidemicSurveillanceRepository.save(epidemic);
            result.put("status", 200);
            result.put("msg", "编辑成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "编辑失败");
        }
        return result;
    }


    @ApiOperation("添加防控数据")
    @PostMapping("/addEpidemicSurveillance")
    public Map<String, Object> addEpidemicSurveillance(@RequestBody EpidemicSurveillance epidemicSurveillance) {
        Map<String, Object> result = new HashMap<>();
        try {
            epidemicSurveillance.setCreateTime(new Date());
            result.put("data", epidemicSurveillanceRepository.save(epidemicSurveillance));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新防控数据")
    @PutMapping("/updateEpidemicSurveillance")
    public Map<String, Object> updateEpidemicSurveillance(@RequestBody EpidemicSurveillance epidemicSurveillance) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", epidemicSurveillanceRepository.save(epidemicSurveillance));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }


    /**
     * 获取防控疫情
     *
     * @return
     */
    @ApiOperation("查询防控数据")
    @GetMapping("/epidemicSurveillance")
    public Map<String, Object> getEpidemicSurveillance() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", epidemicSurveillanceRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("msg", "获取失败");
            result.put("status", 203);
        }

        return result;
    }

    /**
     * 根据ID删除数据
     *
     * @return
     */
    @ApiOperation("根据ID删除防控数据")
    @DeleteMapping("/epidemicSurveillance/{id}")
    public Map<String, Object> delEpidemicSurveillance(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            epidemicSurveillanceRepository.deleteById(id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "操作失败");
        }
        return result;
    }

}
