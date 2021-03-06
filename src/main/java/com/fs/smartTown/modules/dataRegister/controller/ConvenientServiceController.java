package com.fs.smartTown.modules.dataRegister.controller;

import com.fs.smartTown.modules.dataRegister.dao.AppealTypeRepository;
import com.fs.smartTown.modules.dataRegister.dao.ConvenientServiceRepository;
import com.fs.smartTown.modules.dataRegister.entity.ConvenientService;

import com.fs.smartTown.modules.dataRegister.entity.ConvenientServiceExcel;
import com.fs.smartTown.modules.dataRegister.utils.ExcelUtils;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 */
@Api(tags = "便民服务")
@RestController
public class ConvenientServiceController {

    @Autowired
    private ConvenientServiceRepository convenientServiceRepository;
    @Autowired
    private AppealTypeRepository appealTypeRepository;


    @ApiOperation("添加便民服务")
    @PostMapping("/addConvenientService")
    public Map<String, Object> addConvenientService(@RequestBody ConvenientService convenientService) {
        Map<String, Object> result = new HashMap<>();
        try {
            convenientService.setCreateTime(new Date());
            result.put("data", convenientServiceRepository.save(convenientService));
            result.put("status", 200);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "添加失败");
        }
        return result;
    }

    private String getConvenientType(Integer type){
        String convenientType = "";
        if (type == 1){
            convenientType = "个人诉求";
        } else if (type == 2){
            convenientType = "民意诉求";
        } else if (type == 3){
            convenientType = "业务诉求";
        } else if (type == 4){
            convenientType = "政策咨询";
        } else {
            convenientType = "业务办理";
        }
        return convenientType;
    }

    private String getConvenientState(Integer state){
        String convenientState = "";
        if (state == 1){
            convenientState = "正在办理";
        } else {
            convenientState = "已解决";
        }
        return convenientState;
    }

    @ApiOperation("添加便民服务")
    @PostMapping("/exportConvenientService")
    public void exportConvenientService(@RequestBody List<Integer> ids) {
        try {
            List<ConvenientService> convenientServices= convenientServiceRepository.findAllById(ids);
            List<ConvenientServiceExcel> resultList = new ArrayList<ConvenientServiceExcel>();
            for (ConvenientService convenientService: convenientServices) {
                ConvenientServiceExcel convenientServiceExcel = new ConvenientServiceExcel();
                convenientServiceExcel.setName(convenientService.getName());
                convenientServiceExcel.setPhone(convenientService.getPhone());
                convenientServiceExcel.setType(getConvenientType(convenientService.getType()));
                convenientServiceExcel.setContent(convenientService.getContent());
                convenientServiceExcel.setState(getConvenientState(convenientService.getState()));
                convenientServiceExcel.setReturnContent(convenientService.getReturnContent());
                DateFormat dateFormat = DateFormat.getDateInstance();
                convenientServiceExcel.setCreateTime(dateFormat.format(convenientService.getCreateTime()));
                convenientServiceExcel.setFinishTime(dateFormat.format(convenientService.getFinishTime()));
                resultList.add(convenientServiceExcel);
            }
            RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
            HttpServletResponse response = ((ServletRequestAttributes)attributes).getResponse();
            ExcelUtils.writeExcel(response, resultList, ConvenientServiceExcel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ApiOperation("查询便民服务")
    @GetMapping("/getConvenientService")
    public Map<String, Object> getConvenientService() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", convenientServiceRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime")));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }
    @ApiOperation("查询便民服务所有类型")
    @GetMapping("/getAllAppealType")
    public Map<String, Object> getAllAppealType() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", appealTypeRepository.findAll());
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询便民服务")
    @GetMapping("/getConvenientServiceList")
    public Map<String, Object> getConvenientServiceList(@RequestParam("userId") Integer userId,
                                                        @RequestParam("state") Integer state,
                                                        @RequestParam("isDelete") Integer isDelete) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", convenientServiceRepository.findConvenientServiceList(userId, state, isDelete));
            result.put("status", 200);
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
        }
        return result;
    }

    @ApiOperation("查询便民服务:类型，创建时间，状态")
    @GetMapping("/getConvenientsByTypeAndStateAndTime")
    public Map<String, Object> findAllByTypeAndCreateTimeAndState(@RequestParam("type") Integer type,
                                                        @RequestParam("date") String date,
                                                        @RequestParam("state") Integer state) {
        Map<String, Object> result = new HashMap<>();
        try {
            Date dateFormat = null;
            if (!date.equals("")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
                dateFormat = sdf.parse(date);
            }

            List<ConvenientService> convenientServices1 = new ArrayList<>();
            List<ConvenientService> convenientServices = convenientServiceRepository.findAllByTypeAndState(type, state);

            if (dateFormat == null) {
                result.put("data", convenientServices);
                result.put("status", 200);
                result.put("msg", "获取成功");
            } else {
                for (ConvenientService convenientService : convenientServices){
                    if (convenientService.getCreateTime().compareTo(dateFormat) == 0){
                        convenientServices1.add(convenientService);
                    }
                }
                result.put("data", convenientServices1);
                result.put("status", 200);
                result.put("msg", "获取成功");
            }
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "获取失败");
            e.printStackTrace();
        }
        return result;
    }


    @ApiOperation("更新便民服务")
    @PutMapping("/updateConvenientService")
    public Map<String, Object> updateConvenientService(@RequestBody ConvenientService convenientService) {
        Map<String, Object> result = new HashMap<>();
        try {
            ConvenientService convenientServiceInfo = convenientServiceRepository.findByBmId(convenientService.getBmId());
            if (convenientService.getReturnContent() != null) {
                convenientServiceInfo.setReturnContent(convenientService.getReturnContent());
                convenientServiceInfo.setFinishTime(new Date());
                convenientServiceInfo.setState(convenientService.getState());
            } else {
                convenientServiceInfo.setIsDelete(convenientService.getIsDelete());
            }
            result.put("data", convenientServiceRepository.save(convenientServiceInfo));
            result.put("status", 200);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            result.put("status", 203);
            result.put("msg", "更新失败");
        }
        return result;
    }


    @ApiOperation("根据ID删除便民服务")
    @DeleteMapping("/spb/delConvenientService/{id}")
    public Map<String, Object> delStudyInformation(@ApiParam("被删除的ID") @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            convenientServiceRepository.deleteById(id);
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
