package com.fs.smartTown.modules.auth.controller;

import com.fs.smartTown.modules.auth.entity.Role;
import com.fs.smartTown.modules.auth.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "角色管理apis")
@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(value = "获取角色列表")
    @GetMapping("")
    public Map<String, Object> getRoles(){
        Map<String, Object> result = new HashMap<>();
        List<Role> roles = roleService.getAllRoles();
        result.put("data", roles);
        result.put("status", 200);
        return result;
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("")
    public Map<String, Object> addRole(@RequestBody Role role){
        Map<String, Object> result = new HashMap<>();
        try {
            Role addedRole =  roleService.addRole(role);
            result.put("data", addedRole);
            result.put("status", 200);
            result.put("msg", "添加成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "操作失败");
            e.printStackTrace();
        }
        return result;
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("")
    public Map<String, Object> updateRole(@RequestBody Role role){
        Map<String, Object> result = new HashMap<>();
        try {
            Role addedRole =  roleService.updateRole(role);
            result.put("data", addedRole);
            result.put("status", 200);
            result.put("msg", "修改成功");
        }catch (Exception e){
            result.put("data", null);
            result.put("status", 200);
            result.put("msg", "操作失败");
        }
        return result;
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/{roleId}")
    public Map<String, Object> deleteRole(@PathVariable Integer roleId){
        Map<String, Object> result = new HashMap<>();
        try {
            roleService.deleteRole(roleId);
            result.put("data", roleId);
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
