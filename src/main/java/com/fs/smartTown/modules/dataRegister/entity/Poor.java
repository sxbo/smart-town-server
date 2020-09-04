package com.fs.smartTown.modules.dataRegister.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description 贫困信息
 * @throws
 * @author Target
 *  @date 2020/8/28 3:29 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "poor_users") //映射的表名称
public class Poor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String idCard;
    private String village;
    private String outputValue;
    private String phone;
}
