package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.ScreenMonitorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "数据大屏监控")
@RestController
public class ScreenMonitorController {
    @Autowired
    private ScreenMonitorRepository screenMonitorRepository;

    @ApiOperation("大屏监控序列查询")
    @GetMapping("/getScreenMonitor")
    public Map<String, Object> getAllScreenMonitors() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", screenMonitorRepository.getAllScreenMonitor());
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
