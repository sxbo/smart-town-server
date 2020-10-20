package com.fs.smartTown.modules.dataRegister.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Target
 * @description 便民服务
 * @throws
 * @date 2020/8/28 3:29 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "bm_convenient_service") //映射的表名称
public class ConvenientService {
    @Id
    @ApiModelProperty(value = "主键", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bmId;
    private Integer userId;
    private String name;
    private String phone;
    // 1、个人诉求', '2、民意诉求', '3、业务诉求', '4、政策咨询', '5、业务办理
    private Integer type;
    private String typeName;
    private String content;
    private String returnContent;
    // 1、正在办理 2、已解决
    private Integer state;
    // 1、已删除 2、未删除
    private Integer isDelete;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date finishTime;
}
