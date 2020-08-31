package com.fs.smartTown.modules.dataRegister.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @GeneratedValue
    private Long id;
    private String name;
    private String idCard;
    private String village;
    private String createTime;
    private Integer state;
}
