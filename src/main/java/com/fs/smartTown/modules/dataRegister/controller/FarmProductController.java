package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.FarmProductRepository;
import com.fs.smartTown.modules.dataRegister.dao.FarmProductTypeRepository;
import com.fs.smartTown.modules.dataRegister.entity.FarmProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "动态信息")
@RestController
public class FarmProductController {

    @Autowired
    private FarmProductRepository farmProductRepository;
    @Autowired
    private FarmProductTypeRepository farmProductTypeRepository;

    @ApiOperation("查询全部农副产品类型")
    @GetMapping("/getAllFarmTypes")
    public Map<String, Object> getAllFarmTypes() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", farmProductTypeRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation("添加农副产品信息")
    @PostMapping("/spb/addFarmProduct")
    public Map<String, Object> addFarmProduct(@RequestBody FarmProduct farmProduct) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", farmProductRepository.save(farmProduct));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }


    @ApiOperation("按类型查询农产品信息")
    @GetMapping("/spb/getFarmProductByType")
    public Map<String, Object> getFarmProductByType(@RequestParam("type") Integer type) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", farmProductRepository.findAllByTypeId(type));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询全部农产品信息")
    @GetMapping("/spb/getAllFarmProduct")
    public Map<String, Object> getAllFarmProduct() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", farmProductRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("查询动态富文本")
    @GetMapping("/spb/getFarmProductRichText")
    public Map<String, Object> getFarmProductRichText(@RequestParam("id") Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", farmProductRepository.findById(id));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }


    @ApiOperation("更新农产品信息")
    @PutMapping("/spb/updateFarmProduct")
    public Map<String, Object> updateFarmProduct(@RequestBody FarmProduct farmProduct) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", farmProductRepository.save(farmProduct));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }


    @ApiOperation("根据ID删除动态信息")
    @DeleteMapping("/spb/delFarmProduct")
    public Map<String, Object> delFarmProduct(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            farmProductRepository.deleteById(id);
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
