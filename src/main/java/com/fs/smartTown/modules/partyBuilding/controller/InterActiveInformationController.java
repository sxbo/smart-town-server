package com.fs.smartTown.modules.partyBuilding.controller;

import com.fs.smartTown.modules.partyBuilding.dao.DynamicInformationRepository;
import com.fs.smartTown.modules.partyBuilding.dao.InterActiveInCommentRepository;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@Api(tags = "互动信息")
@RestController
public class InterActiveInformationController {


    @Autowired
    private InterActiveInformationRepository interActiveInformationRepository;

    @Autowired
    private InterActiveInCommentRepository interActiveInCommentRepository;


    @ApiOperation("添加互动信息")
    @PostMapping("/spb/addInterActiveInformation")
    public Map<String, Object> addInterActiveInformation(@RequestBody InterActiveInformation interActiveInformation) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", interActiveInformationRepository.save(interActiveInformation));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("查询互动信息")
    @GetMapping("/spb/getInterActiveInformation")
    public Map<String, Object> getInterActiveInformation() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> item = new HashMap<>();
        List<InterActiveInformation> interActiveInformationList = interActiveInformationRepository.findAll();
        for (InterActiveInformation interActiveInformation : interActiveInformationList) {
            interActiveInformation.setComments(interActiveInCommentRepository.findByBbsId(interActiveInformation.getBbsId()));
            item.put("interActives", interActiveInformation);
            list.add(item);
        }
        try {
            result.put("data", list);
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("更新互动信息")
    @PutMapping("/spb/updateInterActiveInformation")
    public Map<String, Object> updateInterActiveInformation(@RequestBody InterActiveInformation interActiveInformation) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("根据ID删除互动信息")
    @DeleteMapping("/spb/delInterActiveInformation")
    public Map<String, Object> delInterActiveInformation
            (@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }

}
