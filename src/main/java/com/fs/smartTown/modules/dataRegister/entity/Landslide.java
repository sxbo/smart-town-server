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
 * @description 山体滑坡
 * @throws
 * @author Target
 *  @date 2020/8/28 3:29 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "landslide") //映射的表名称
public class Landslide {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private String personCharge;
    private String phone;
    private String alarmNum;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;
}
