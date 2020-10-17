package com.fs.smartTown.modules.partyBuilding.controller;

import com.fs.smartTown.modules.partyBuilding.dao.DynamicInformationRepository;
import com.fs.smartTown.modules.partyBuilding.dao.DynamicTypeRepository;
import com.fs.smartTown.modules.partyBuilding.entity.DynamicInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
@Api(tags = "动态信息")
@RestController
public class DynamicInformationController {

    @Autowired
    private DynamicInformationRepository dynamicInformationRepository;
    @Autowired
    private DynamicTypeRepository dynamicTypeRepository;

    @ApiOperation("查询全部动态信息类型")
    @GetMapping("/getAllDynamicTypes")
    public Map<String, Object> getAllDynamicTypes() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", dynamicTypeRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation("添加动态信息")
    @PostMapping("/spb/addDynamicInformation")
    public Map<String, Object> addDynamicInformation(@RequestBody DynamicInformation dynamicInformation) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", dynamicInformationRepository.save(dynamicInformation));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("查询动态信息")
    @GetMapping("/spb/getDynamicInformation")
    public Map<String, Object> getDynamicInformation(@RequestParam("type") Integer type) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", dynamicInformationRepository.findAllByTypeId(type));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询全部动态信息")
    @GetMapping("/spb/getAllDynamicInformation")
    public Map<String, Object> getAllDynamicInformation() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", dynamicInformationRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("查询动态富文本")
    @GetMapping("/spb/getDynamicRichText")
    public Map<String, Object> getDynamicRichText(@RequestParam("id") Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", dynamicInformationRepository.findById(id));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("更新动态信息")
    @PutMapping("/spb/updateDynamicInformation")
    public Map<String, Object> updateDynamicInformation(@RequestBody DynamicInformation dynamicInformation) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", dynamicInformationRepository.save(dynamicInformation));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }


    @ApiOperation("根据ID删除动态信息")
    @DeleteMapping("/spb/delDynamicInformation")
    public Map<String, Object> delDynamicInformation(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            dynamicInformationRepository.deleteById(id);
            result.put("data", id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "删除失败");
        }
        return result;
    }


}
