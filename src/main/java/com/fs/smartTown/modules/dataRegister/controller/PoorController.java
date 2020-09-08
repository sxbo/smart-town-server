package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.EpidemicSurveillanceRepository;
import com.fs.smartTown.modules.dataRegister.dao.PoorRepository;
import com.fs.smartTown.modules.dataRegister.entity.EpidemicSurveillance;
import com.fs.smartTown.modules.dataRegister.entity.Poor;

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
 * 　　* @description: 贫困数据
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "贫困信息")
@RestController
public class PoorController {

    @Autowired
    private PoorRepository poorRepository;

    /**
     * 添加防控登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名"),
            @ApiImplicitParam(name = "idCard", value = "身份证"),
            @ApiImplicitParam(name = "village", value = "所属村"),
            @ApiImplicitParam(name = "outputValue", value = "人均产值"),
            @ApiImplicitParam(name = "phone", value = "联系电话"),
    })
    @ApiOperation("添加贫困信息数据")
    @PostMapping("/sys/poor")
    public Map<String, Object> addPoor(@RequestParam("name") String name,
                                       @RequestParam("idCard") String idCard,
                                       @RequestParam("village") String village,
                                       @RequestParam("outputValue") String outputValue,
                                       @RequestParam("phone") String phone) {
        Map<String, Object> result = new HashMap<>();
        Poor poor = new Poor();
        poor.setName(name);
        poor.setIdCard(idCard);
        poor.setVillage(village);
        poor.setOutputValue(outputValue);
        poor.setPhone(phone);
        Poor poorResult = poorRepository.save(poor);
        if (poorResult != null) {
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
    @ApiOperation("查询贫困信息数据")
    @GetMapping("/sys/poor")
    public Map<String, Object> getPoor() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", poorRepository.findAll());
        result.put("status", 200);
        return result;
    }

    /**
     * 根据ID删除数据
     *
     * @return
     */
    @ApiOperation("根据ID删除贫困信息")
    @DeleteMapping("/sys/poor")
    public Map<String, Object> delPoor(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        poorRepository.deleteById(id);
        result.put("status", 200);
        result.put("msg", "删除成功");
        return result;
    }

}
