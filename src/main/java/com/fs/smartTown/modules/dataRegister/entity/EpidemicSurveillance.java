package com.fs.smartTown.modules.dataRegister.entity;

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
 * @description 疫情监控
 * @throws
 * @author Target
 *  @date 2020/8/28 3:29 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "epidemic_surveillance") //映射的表名称
public class EpidemicSurveillance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String idCard;
    private String village;
    private String createTime;
    // 1, 确诊， 2，治愈，3，隔离，4， 无症状
    @ApiModelProperty(value = "状态", example = "1")
    private Integer state;
    // 1.男， 2.女
    private Integer sexType;
}
