package com.fs.smartTown.modules.auth.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "monitor_classification") //映射的表名称
public class MonitorClassification {
    @Id
    @ApiModelProperty(value = "ID", example = "1")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    //1、景区  2、山体
    private Integer monitorType;
    private String seriaNumber;

}

