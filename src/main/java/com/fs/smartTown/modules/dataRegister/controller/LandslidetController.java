package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.LandslideRepository;
import com.fs.smartTown.modules.dataRegister.entity.Landslide;

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
@Api(tags = "山体滑坡")
@RestController
public class LandslidetController {

    @Autowired
    private LandslideRepository landslideRepository;

    /**
     * 添加山体登记数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "地址"),
            @ApiImplicitParam(name = "personCharge", value = "负责人"),
            @ApiImplicitParam(name = "phone", value = "电话"),
    })
    @PostMapping("/sys/landslide")
    public Map<String, Object> addLandslide(@RequestParam("address") String address,
                                            @RequestParam("personCharge") String personCharge,
                                            @RequestParam("phone") String phone) {
        Map<String, Object> result = new HashMap<>();
        Landslide landslide = new Landslide();
        landslide.setAddress(address);
        landslide.setPersonCharge(personCharge);
        landslide.setPhone(phone);
        Landslide landslideResult = landslideRepository.save(landslide);
        if (landslideResult != null) {
            result.put("status", 200);
            result.put("msg", "添加成功");
        } else {
            result.put("status", 200);
            result.put("msg", "添加失败");
        }
        return result;
    }


}
