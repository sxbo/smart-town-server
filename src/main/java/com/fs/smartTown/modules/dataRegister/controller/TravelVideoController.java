package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.TravelVideoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "旅游宣传")
@RestController
public class TravelVideoController {
    @Autowired
    private TravelVideoRepository travelVideoRepository;

    @ApiOperation("查询旅游宣传视频")
    @GetMapping("/getTravelVideos")
    public Map<String, Object> getTravelVideos() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", travelVideoRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
            e.printStackTrace();
        }
        return result;
    }
}
