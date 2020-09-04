package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.BreedRepository;
import com.fs.smartTown.modules.dataRegister.dao.LandCirculationRepository;
import com.fs.smartTown.modules.dataRegister.entity.Breed;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;
import com.fs.smartTown.modules.dataRegister.entity.LandCirculation;

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
    @PostMapping("/sys/landCirculation")
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
        LandCirculation landCirculationResult = landCirculationRepository.save(landCirculation);
        if (landCirculationResult != null) {
            result.put("status", 200);
            result.put("msg", "添加成功");
        } else {
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }


    /**
     * 获取土地流转
     *
     * @return
     */
    @ApiOperation("查询土地流转")
    @GetMapping("/sys/landCirculation")
    public List<LandCirculation> getLandCirculation() {
        return landCirculationRepository.findAll();
    }


    /**
     * 根据ID删除数据
     *
     * @return
     */
    @ApiOperation("根据ID删除土地流转数据")
    @DeleteMapping("/sys/landCirculation")
    public Map<String, Object> delLandCirculation(@ApiParam("被删除的ID")@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        landCirculationRepository.deleteById(id);
        result.put("status", 200);
        result.put("msg", "删除成功");
        return result;
    }



}
