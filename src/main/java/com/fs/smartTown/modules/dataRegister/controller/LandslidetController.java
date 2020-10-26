package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.LandslideRepository;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;
import com.fs.smartTown.modules.dataRegister.entity.LandCirculation;
import com.fs.smartTown.modules.dataRegister.entity.Landslide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
 * 　　* @description: 山体滑坡
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "山体滑坡")
@RestController
public class LandslidetController {

    @Autowired
    private LandslideRepository landslideRepository;

    /**
     * 添加山体登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "地址"),
            @ApiImplicitParam(name = "personCharge", value = "负责人"),
            @ApiImplicitParam(name = "phone", value = "电话"),
    })
    @ApiOperation("添加山体滑坡数据")
    @PostMapping("/landslide")
    public Map<String, Object> addLandslide(@RequestParam("address") String address,
                                            @RequestParam("personCharge") String personCharge,
                                            @RequestParam("phone") String phone) {
        Map<String, Object> result = new HashMap<>();
        Landslide landslide = new Landslide();
        landslide.setAddress(address);
        landslide.setPersonCharge(personCharge);
        landslide.setPhone(phone);
        landslide.setAlarmNum("0");
        landslide.setCreateTime(new Date());
        try {
            landslide.setAlarmNum("0");
            landslideRepository.save(landslide);
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("添加山体滑坡数据")
    @PostMapping("/addLandslide")
    public Map<String, Object> addLandslide(@RequestBody Landslide landslide) {
        Map<String, Object> result = new HashMap<>();
        try {
            landslide.setCreateTime(new Date());
            landslide.setAlarmNum("0");
            result.put("data", landslideRepository.save(landslide));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新山体滑坡数据")
    @PutMapping("/updateLandslide")
    public Map<String, Object> updateLandslide(@RequestBody Landslide landslide) {
        Map<String, Object> result = new HashMap<>();
        try {
            landslide.setCreateTime(new Date());
            result.put("data", landslideRepository.save(landslide));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }

    /**
     * 获取山体滑坡
     *
     * @return
     */
    @ApiOperation("查询山体滑坡数据")
    @GetMapping("/landslide")
    public Map<String, Object> getLandslide() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", landslideRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime")));
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
    @ApiOperation("根据ID删除山体滑坡数据")
    @DeleteMapping("/landslide/{id}")
    public Map<String, Object> delLandslide(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            landslideRepository.deleteById(id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "操作失败");
        }
        return result;
    }

}
