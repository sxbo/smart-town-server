package com.fs.smartTown.modules.partyBuilding.controller;

import com.fs.smartTown.modules.auth.entity.User;
import com.fs.smartTown.modules.dataRegister.dao.BreedRepository;
import com.fs.smartTown.modules.dataRegister.entity.Breed;
import com.fs.smartTown.modules.partyBuilding.dao.AdvertisementRepository;
import com.fs.smartTown.modules.partyBuilding.entity.Advertisement;

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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 　　* @description: TODO  Banner广告
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:31 下午
 */

@Api(tags = "Banner广告")
@RestController
public class AdvBannerController {

    @Autowired
    private AdvertisementRepository advertisementRepository;


    @ApiOperation("添加Banner广告")
    @PostMapping("/spb/addAdvertisement")
    public Map<String, Object> addAdvertisement(@RequestBody Advertisement advertisement) {
        Map<String, Object> result = new HashMap<>();
        try {
            advertisement.setCreateTime(new Date());
            result.put("data", advertisementRepository.save(advertisement));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("查询Banner广告")
    @GetMapping("/spb/getAdvertisement")
    public Map<String, Object> getAdvertisement(@RequestParam("type") Integer type) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", advertisementRepository.findByType(type, Sort.by(Sort.Direction.DESC, "createTime")));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询全部Banner广告")
    @GetMapping("/spb/getAllAdvertisement")
    public Map<String, Object> getAllAdvertisement() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", advertisementRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime")));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新Banner广告")
    @PutMapping("/spb/updateAdvertisement")
    public Map<String, Object> updateAdvertisement(@RequestBody Advertisement advertisement) {
        Map<String, Object> result = new HashMap<>();
        try {
            advertisement.setCreateTime(new Date());
            result.put("data", advertisementRepository.save(advertisement));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }


    @ApiOperation("根据ID删除Banner广告")
    @DeleteMapping("/spb/delAdvertisement/{id}")
    public Map<String, Object> delAdvertisement(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            advertisementRepository.deleteById(id);
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
