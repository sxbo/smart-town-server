package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.FarmCountRepository;
import com.fs.smartTown.modules.dataRegister.dao.MemberCountRepository;
import com.fs.smartTown.modules.dataRegister.dao.PriceSellRepository;
import com.fs.smartTown.modules.dataRegister.entity.PriceSell;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "价格销量api")
@RestController
public class PriceSellController {
    @Autowired
    private PriceSellRepository priceSellRepository;
    @Autowired
    private FarmCountRepository farmCountRepository;
    @Autowired
    private MemberCountRepository memberCountRepository;


    @ApiOperation("添加价格销量数据")
    @PostMapping("/addPriceSell")
    public Map<String, Object> addPriceSell(@RequestBody PriceSell priceSell) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", priceSellRepository.save(priceSell));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新价格销量数据")
    @PutMapping("/updatePriceSell")
    public Map<String, Object> updatePriceSell(@RequestBody PriceSell priceSell) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", priceSellRepository.save(priceSell));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }

    /**
     * 获取列表
     *
     * @return
     */
    @ApiOperation("获取所有价格销量数据")
    @GetMapping("/priceSells")
    public Map<String, Object> getPriceSell() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", priceSellRepository.findAll());
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
    @ApiOperation("根据ID删除价格销量数据")
    @DeleteMapping("/priceSell/{id}")
    public Map<String, Object> delPriceSell(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            priceSellRepository.deleteById(id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "操作失败");
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation("获取所有类型")
    @GetMapping("/getAllFarmCount")
    public Map<String, Object> getAllFarmCount() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", farmCountRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("获取所有村")
    @GetMapping("/getAllVillage")
    public Map<String, Object> getAllVillage() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", memberCountRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }
}
