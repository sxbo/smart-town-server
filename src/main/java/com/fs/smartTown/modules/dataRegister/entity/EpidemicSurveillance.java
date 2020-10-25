package com.fs.smartTown.modules.dataRegister.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;
    // 1, 确诊， 2，治愈，3，隔离，4， 无症状
    @ApiModelProperty(value = "状态", example = "1")
    private Integer state;
    // 1.男， 2.女
    private Integer sexType;
}
