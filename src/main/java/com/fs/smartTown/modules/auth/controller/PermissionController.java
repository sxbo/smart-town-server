package com.fs.smartTown.modules.auth.controller;

import com.fs.smartTown.modules.auth.entity.Permission;
import com.fs.smartTown.modules.auth.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "权限管理apis")
@RestController
@RequestMapping("/permission")
public class PermissionController {
    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @ApiOperation(value = "获取权限列表", tags = "permission")
    @GetMapping("")
    public Map<String, Object> permissions(){
        Map<String, Object> result = new HashMap<>();
        List<Permission> permissions = permissionService.getAllPermission();
        result.put("data", permissions);
        result.put("status", 200);
        return result;
    }

    @ApiOperation(value = "添加权限")
    @PostMapping("")
    public Map<String, Object> addPermission(@RequestBody Permission permission){
        Map<String, Object> result = new HashMap<>();
        try {
            Permission addedPermission =  permissionService.addPermission(permission);
            result.put("data", addedPermission);
            result.put("status", 200);
            result.put("msg", "添加成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "操作失败");
        }
        return result;
    }

    @ApiOperation(value = "修改权限")
    @PutMapping("")
    public Map<String, Object> updatePermission(@RequestBody Permission permission){
        Map<String, Object> result = new HashMap<>();
        try {
            Permission addedPermission =  permissionService.updatePermission(permission);
            result.put("data", addedPermission);
            result.put("status", 200);
            result.put("msg", "修改成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "操作失败");
        }
        return result;
    }

    @ApiOperation(value = "删除权限")
    @DeleteMapping("")
    public Map<String, Object> deletePermission(@PathVariable Integer permissionId){
        Map<String, Object> result = new HashMap<>();
        try {
            permissionService.deletePermission(permissionId);
            result.put("data", permissionId);
            result.put("status", 200);
            result.put("msg", "删除成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "操作失败");
        }
        return result;
    }
}
