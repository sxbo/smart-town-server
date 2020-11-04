package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.BreedRepository;
import com.fs.smartTown.modules.dataRegister.dao.LandCirculationRepository;
import com.fs.smartTown.modules.dataRegister.entity.Breed;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;
import com.fs.smartTown.modules.dataRegister.entity.LandCirculation;

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
 * 　　* @description: 土地流转
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "土地流转")
@RestController
public class LandCirculationController {

    @Autowired
    private LandCirculationRepository landCirculationRepository;

    /**
     * 添加土地流转登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inflowSide", value = "流入方"),
            @ApiImplicitParam(name = "location", value = "流转土地位置"),
            @ApiImplicitParam(name = "circulationPeriod", value = "流转期限"),
            @ApiImplicitParam(name = "landAreaName", value = "土地面积"),
            @ApiImplicitParam(name = "outflowSide", value = "流出方"),
    })
    @ApiOperation("添加土地流转数据")
    @PostMapping("/landCirculation")
    public Map<String, Object> addLandCirculation(@RequestParam("inflowSide") String inflowSide,
                                                  @RequestParam("location") String location,
                                                  @RequestParam("circulationPeriod") String circulationPeriod,
                                                  @RequestParam("landAreaName") String landAreaName,
                                                  @RequestParam("outflowSide") String outflowSide) {
        Map<String, Object> result = new HashMap<>();
        LandCirculation landCirculation = new LandCirculation();
        landCirculation.setInflowSide(inflowSide);
        landCirculation.setLocation(location);
        landCirculation.setCirculationPeriod(circulationPeriod);
        landCirculation.setLandAreaName(landAreaName);
        landCirculation.setOutflowSide(outflowSide);
        landCirculation.setCreateTime(new Date());
        try {
            landCirculationRepository.save(landCirculation);
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("添加土地流转")
    @PostMapping("/addLandCirculation")
    public Map<String, Object> addLandCirculation(@RequestBody LandCirculation landCirculation) {
        Map<String, Object> result = new HashMap<>();
        landCirculation.setCreateTime(new Date());
        try {
            landCirculation.setCreateTime(new Date());
            result.put("data", landCirculationRepository.save(landCirculation));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新土地流转")
    @PutMapping("/updateLandCirculation")
    public Map<String, Object> updateLandCirculation(@RequestBody LandCirculation landCirculation) {
        Map<String, Object> result = new HashMap<>();
        landCirculation.setCreateTime(new Date());
        try {
            result.put("data", landCirculationRepository.save(landCirculation));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获取土地流转
     *
     * @return
     */
    @ApiOperation("查询土地流转")
    @GetMapping("/landCirculation")
    public Map<String, Object> getLandCirculation() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", landCirculationRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime")));
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
    @ApiOperation("根据ID删除土地流转数据")
    @DeleteMapping("/landCirculation/{id}")
    public Map<String, Object> delLandCirculation(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            landCirculationRepository.deleteById(id);
            result.put("status", 200);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "操作失败");
        }
        return result;
    }

    @ApiOperation("查询土地流转数据:流出方、流入方、位置")
    @GetMapping("/filterLandCirculation")
    public Map<String, Object> findByEpidemicSurveillanceList(@RequestParam("outflowSide") String outflowSide,
                                                              @RequestParam("inflowSide") String inflowSide,
                                                              @RequestParam("location") String location) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", landCirculationRepository.filterLandCirculation(outflowSide, inflowSide, location));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

}
