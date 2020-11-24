package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.PromotionalVideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 　　* @description: 宣传视频
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "宣传视频")
@RestController
public class PromotionalVideoController {

    @Autowired
    private PromotionalVideoRepository promotionalVideoRepository;



    /**
     * 获取宣传视频
     *
     * @return
     */
    @ApiOperation("获取宣传视频")
    @GetMapping("/promotionalVideo")
    public Map<String, Object> getPromotionalVideo() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", promotionalVideoRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


}
