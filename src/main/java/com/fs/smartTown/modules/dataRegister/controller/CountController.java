package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.FarmCountRepository;
import com.fs.smartTown.modules.dataRegister.dao.MemberCountRepository;
import com.fs.smartTown.modules.dataRegister.dao.MonitorCountRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "水产养殖")
@RestController
public class CountController {
    @Autowired
    private MemberCountRepository memberCountRepository;
    @Autowired
    private MonitorCountRepository monitorCountRepository;
    @Autowired
    private FarmCountRepository farmCountRepository;


    @ApiOperation("查询党员统计信息")
    @GetMapping("/getPartyMemberCount")
    public Map<String, Object> getPartyMember() {
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

    @ApiOperation("查询监控统计信息")
    @GetMapping("/getMonitorCount")
    public Map<String, Object> getMonitorCount() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", monitorCountRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询农业分布统计信息")
    @GetMapping("/getFarmCount")
    public Map<String, Object> getFarmCount() {
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
}
