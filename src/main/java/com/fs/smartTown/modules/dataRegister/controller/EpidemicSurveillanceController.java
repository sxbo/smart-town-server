package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.EpidemicSurveillanceRepository;
import com.fs.smartTown.modules.dataRegister.entity.EpidemicSurveillance;

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
    @PostMapping("/sys/epidemicSurveillance")
    public Map<String, Object> addEpidemicSurveillance(@RequestParam("name") String name,
                                                       @RequestParam("idCard") String idCard,
                                                       @RequestParam("village") String village,
                                                       @RequestParam("createTime") String createTime,
                                                       @RequestParam("state") Integer state,
                                                       @RequestParam("sexType") Integer sexType) {
        Map<String, Object> result = new HashMap<>();
        EpidemicSurveillance epidemicSurveillance = new EpidemicSurveillance();
        epidemicSurveillance.setName(name);
        epidemicSurveillance.setIdCard(idCard);
        epidemicSurveillance.setVillage(village);
        epidemicSurveillance.setCreateTime(createTime);
        epidemicSurveillance.setState(state);
        epidemicSurveillance.setSexType(sexType);
        EpidemicSurveillance surveillance = epidemicSurveillanceRepository.save(epidemicSurveillance);
        if (surveillance != null) {
            result.put("status", 200);
            result.put("msg", "添加成功");
        } else {
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }


    /**
     * 获取防控疫情
     *
     * @return
     */
    @ApiOperation("查询防控数据")
    @GetMapping("/sys/epidemicSurveillance")
    public List<EpidemicSurveillance> getEpidemicSurveillance() {
        return epidemicSurveillanceRepository.findAll();
    }

    /**
     * 根据ID删除数据
     *
     * @return
     */
    @ApiOperation("根据ID删除防控数据")
    @DeleteMapping("/sys/epidemicSurveillance")
    public Map<String, Object> delEpidemicSurveillance(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        epidemicSurveillanceRepository.deleteById(id);
        result.put("status", 200);
        result.put("msg", "删除成功");
        return result;
    }

}
