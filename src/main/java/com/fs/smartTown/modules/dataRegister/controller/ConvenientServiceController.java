package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.ConvenientServiceRepository;
import com.fs.smartTown.modules.dataRegister.entity.ConvenientService;

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
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 */
@Api(tags = "便民服务")
@RestController
public class ConvenientServiceController {

    @Autowired
    private ConvenientServiceRepository convenientServiceRepository;


    @ApiOperation("添加便民服务")
    @PostMapping("/addConvenientService")
    public Map<String, Object> addConvenientService(@RequestBody ConvenientService convenientService) {
        Map<String, Object> result = new HashMap<>();
        try {
            convenientService.setCreateTime(new Date());
            result.put("data", convenientServiceRepository.save(convenientService));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("查询便民服务")
    @GetMapping("/getConvenientService")
    public Map<String, Object> getConvenientService() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", convenientServiceRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询便民服务")
    @GetMapping("/getConvenientServiceList")
    public Map<String, Object> getConvenientServiceList(@RequestParam("userId") Integer userId,
                                                        @RequestParam("state") Integer state,
                                                        @RequestParam("isDelete") Integer isDelete) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", convenientServiceRepository.findConvenientServiceList(userId, state, isDelete));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("更新便民服务")
    @PostMapping("/updateConvenientService")
    public Map<String, Object> updateConvenientService(@RequestBody ConvenientService convenientService) {
        Map<String, Object> result = new HashMap<>();
        try {
            ConvenientService convenientServiceInfo = convenientServiceRepository.findByBmId(convenientService.getBmId());
            if (convenientService.getReturnContent() != null) {
                convenientServiceInfo.setReturnContent(convenientService.getReturnContent());
                convenientServiceInfo.setFinishTime(new Date());
            } else {
                convenientServiceInfo.setIsDelete(convenientService.getIsDelete());
            }
            result.put("data", convenientServiceRepository.save(convenientService));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }


    @ApiOperation("根据ID删除便民服务")
    @DeleteMapping("/spb/delConvenientService/{id}")
    public Map<String, Object> delStudyInformation(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            convenientServiceRepository.deleteById(id);
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
