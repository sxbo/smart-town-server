package com.fs.smartTown.modules.partyBuilding.controller;

import com.fs.smartTown.modules.partyBuilding.dao.DynamicInformationRepository;
import com.fs.smartTown.modules.partyBuilding.dao.InterActiveInformationRepository;
import com.fs.smartTown.modules.partyBuilding.entity.DynamicInformation;
import com.fs.smartTown.modules.partyBuilding.entity.InterActiveInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@Api(tags = "互动信息")
@RestController
public class InterActiveInformationController {


    @Autowired
    private InterActiveInformationRepository interActiveInformationRepository;


    @ApiOperation("添加互动信息")
    @PostMapping("/spb/addInterActiveInformation")
    public Map<String, Object> addInterActiveInformation(@RequestBody InterActiveInformation interActiveInformation) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("查询互动信息")
    @PutMapping("/spb/getInterActiveInformation")
    public Map<String, Object> getInterActiveInformation() {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("更新互动信息")
    @PostMapping("/spb/updateInterActiveInformation")
    public Map<String, Object> updateInterActiveInformation(@RequestBody InterActiveInformation interActiveInformation) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("根据ID删除互动信息")
    @DeleteMapping("/spb/delInterActiveInformation")
    public Map<String, Object> delInterActiveInformation(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }

}
