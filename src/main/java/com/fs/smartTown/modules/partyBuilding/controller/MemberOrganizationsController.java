package com.fs.smartTown.modules.partyBuilding.controller;

import com.fs.smartTown.modules.partyBuilding.dao.InterActiveInformationRepository;
import com.fs.smartTown.modules.partyBuilding.dao.MemberOrganizationsRepository;
import com.fs.smartTown.modules.partyBuilding.entity.InterActiveInformation;
import com.fs.smartTown.modules.partyBuilding.entity.MemberOrganizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 *
 */
@Api(tags = "党员信息")
@RestController
public class MemberOrganizationsController {

    @Autowired
    private MemberOrganizationsRepository memberOrganizationsRepository;


    @ApiOperation("添加党员信息")
    @PostMapping("/spb/addMemberOrganizations")
    public Map<String, Object> addMemberOrganizations(@RequestBody MemberOrganizations memberOrganizations) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("查询党员信息")
    @GetMapping("/spb/getMemberOrganizations")
    public Map<String, Object> getMemberOrganizations() {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("更新党员信息")
    @PutMapping("/spb/updateMemberOrganizations")
    public Map<String, Object> updateMemberOrganizations(@RequestBody MemberOrganizations memberOrganizations) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }


    @ApiOperation("根据ID删除党员信息")
    @DeleteMapping("/spb/delMemberOrganizations")
    public Map<String, Object> delMemberOrganizations(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }

}
