package com.fs.smartTown.modules.partyBuilding.controller;

import com.fs.smartTown.modules.partyBuilding.dao.MemberOrganizationsRepository;
import com.fs.smartTown.modules.partyBuilding.dao.StudyInformationRepository;
import com.fs.smartTown.modules.partyBuilding.entity.MemberOrganizations;
import com.fs.smartTown.modules.partyBuilding.entity.StudyInformation;

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
@Api(tags = "学习信息")
@RestController
public class StudyInformationController {

    @Autowired
    private StudyInformationRepository studyInformationRepository;


    @ApiOperation("添加学习信息")
    @PostMapping("/spb/addStudyInformation")
    public Map<String, Object> addStudyInformation(@RequestBody StudyInformation studyInformation) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", studyInformationRepository.save(studyInformation));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("查询学习信息")
    @GetMapping("/spb/getStudyInformation")
    public Map<String, Object> getStudyInformation() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", studyInformationRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("查询视频富文本")
    @GetMapping("/spb/getStudyInformationRichText")
    public Map<String, Object> getStudyInformationRichText(@RequestParam("id") Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", studyInformationRepository.findById(id));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }



    @ApiOperation("更新学习信息")
    @PutMapping("/spb/updateStudyInformation")
    public Map<String, Object> updateStudyInformation(@RequestBody StudyInformation studyInformation) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", studyInformationRepository.save(studyInformation));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }


    @ApiOperation("根据ID删除学习信息")
    @DeleteMapping("/spb/delStudyInformation/{id}")
    public Map<String, Object> delStudyInformation(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            studyInformationRepository.deleteById(id);
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
