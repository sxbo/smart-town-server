package com.fs.smartTown.modules.dataRegister.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @GeneratedValue
    private Long id;
    private String helpObj;
    private String village;
    private String personCharge;
    private String helpProject;
    private String createTime;
    private Integer poorState;
    private Integer helpNum;
}
