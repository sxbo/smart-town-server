package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.GreenhouseRepository;
import com.fs.smartTown.modules.dataRegister.entity.Greenhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

/**
 * 　　* @description: 山体滑坡
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/28 5:01 下午
 */
@Api(tags = "大棚")
@RestController
public class GreenhouseController {

    @Autowired
    private GreenhouseRepository greenhouseRepository;

    /**
     * 添加大棚登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manage", value = "管理者"),
            @ApiImplicitParam(name = "phone", value = "电话"),
            @ApiImplicitParam(name = "type", value = "类型"),
            @ApiImplicitParam(name = "name", value = "姓名"),
    })
    @PostMapping("/sys/greenhouse")
    public Map<String, Object> addGreenhouse(@RequestParam("manage") String manage,
                                             @RequestParam("phone") String phone,
                                             @RequestParam("type") Integer type,
                                             @RequestParam("name") String name) {
        Map<String, Object> result = new HashMap<>();
        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setManage(manage);
        greenhouse.setPhone(phone);
        greenhouse.setType(type);
        greenhouse.setName(name);
        Greenhouse greenhouseResult = greenhouseRepository.save(greenhouse);
        if (greenhouseResult != null) {
            result.put("status", 200);
            result.put("msg", "添加成功");
        } else {
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }


}
