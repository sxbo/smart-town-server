package com.fs.smartTown.modules.dataRegister.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 　　* @description: 精准扶贫
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/8/31 1:53 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "poverty_alleviation_record")
        //映射的表名称
public class PovertyAlleviationRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String helpObj;
    private String village;
    private String personCharge;
    private String helpProject;
    private String subName;
    //贫困年度
    private String poorYear;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;
    // 1 已脱贫， 2，未脱贫
    @ApiModelProperty(value = "贫困状态", example = "1")
    private Integer poorState;
    @ApiModelProperty(value = "帮助数", example = "1")
    private Integer helpNum;
}
