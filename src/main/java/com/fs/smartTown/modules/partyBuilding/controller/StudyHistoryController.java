package com.fs.smartTown.modules.partyBuilding.controller;

import com.fs.smartTown.modules.partyBuilding.dao.StudyHistoryRepository;
import com.fs.smartTown.modules.partyBuilding.dao.StudyInformationRepository;
import com.fs.smartTown.modules.partyBuilding.entity.StudyInHistory;
import com.fs.smartTown.modules.partyBuilding.entity.StudyInformation;

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
@Api(tags = "学习记录")
@RestController
public class StudyHistoryController {

    @Autowired
    private StudyHistoryRepository studyHistoryRepository;


    @ApiOperation("添加学习记录")
    @PostMapping("/spb/addStudyHistory")
    public Map<String, Object> addStudyHistoryn(@RequestBody StudyInHistory studyInHistory) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (studyHistoryRepository.findByStudyId(studyInHistory.getStudyId()) == null) {
                result.put("data", studyHistoryRepository.save(studyInHistory));
                result.put("status", 200);
                result.put("msg", "添加成功");
            } else {
                result.put("status", 200);
                result.put("msg", "记录已存在");
            }
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("查询学习记录")
    @GetMapping("/spb/getStudyHistory")
    public Map<String, Object> getStudyHistory() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", studyHistoryRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime")));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("查询学习记录富文本")
    @GetMapping("/spb/getStudyHistoryRichText")
    public Map<String, Object> getStudyHistoryRichText(@RequestParam("id") Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", studyHistoryRepository.findById(id));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("更新学习记录")
    @PutMapping("/spb/updateStudyHistory")
    public Map<String, Object> updateStudyHistory(@RequestBody StudyInHistory studyInHistory) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", studyHistoryRepository.save(studyInHistory));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }


    @ApiOperation("根据ID删除学习记录")
    @DeleteMapping("/spb/delStudyHistory/{id}")
    public Map<String, Object> delStudyHistory(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            studyHistoryRepository.deleteById(id);
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
