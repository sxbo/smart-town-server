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

    @ApiOperation(value = "获取权限列表: 模糊搜索")
    @GetMapping("/search")
    public Map<String, Object> getPermissionsByPermissionLike(@RequestParam("permissionName") String permissionName){
        Map<String, Object> result = new HashMap<>();
        List<Permission> permissions = permissionService.findPermissionsByPermissionNameLike(permissionName);
        result.put("data", permissions);
        result.put("status", 200);
        return result;
    }

    @ApiOperation(value = "添加权限")
    @PostMapping("")
    public Map<String, Object> addPermission(@RequestBody Permission permission){
        Map<String, Object> result = new HashMap<>();
        try {
            Permission permission1 = permissionService.findPermissionByPermissionName(permission.getPermissionName());
            Permission permission2 = permissionService.findPermissionByPermission(permission.getPermission());
            if (permission1 != null || permission2 != null){
                result.put("data", null);
                result.put("status", 400);
                result.put("msg", "添加失败，已存在该权限！");
                return result;
            }
            Permission addedPermission =  permissionService.addPermission(permission);
            result.put("data", addedPermission);
            result.put("status", 200);
            result.put("msg", "添加成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 500);
            result.put("msg", "操作失败");
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation(value = "修改权限")
    @PutMapping("")
    public Map<String, Object> updatePermission(@RequestBody Permission permission){
        Map<String, Object> result = new HashMap<>();
        try {
            Permission permission1 = permissionService.findPermissionByPermissionName(permission.getPermissionName());
            Permission permission2 = permissionService.findPermissionByPermission(permission.getPermission());
            if ((permission1 != null && !permission1.getPermissionId().equals(permission.getPermissionId()))
                    || (permission2 != null && !permission2.getPermissionId().equals(permission.getPermissionId())) ){
                result.put("data", null);
                result.put("status", 400);
                result.put("msg", "添加失败，已存在该权限！");
                return result;
            }
            Permission updatePermission =  permissionService.updatePermission(permission);
            result.put("data", updatePermission);
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
    @DeleteMapping("/{permissionId}")
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
