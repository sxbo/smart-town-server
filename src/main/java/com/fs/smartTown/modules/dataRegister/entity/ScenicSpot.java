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
 * @description 景区
 * @throws
 * @author Target
 *  @date 2020/8/28 3:29 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "scenic_spot") //映射的表名称
public class ScenicSpot {
    @Id
    @ApiModelProperty(value = "主键", example = "1")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String scenicspotName;
    private String address;
    private String personCharge;
    private String personPhone;
}
