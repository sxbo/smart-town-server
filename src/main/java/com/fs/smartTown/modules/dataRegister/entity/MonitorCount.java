package com.fs.smartTown.modules.dataRegister.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @description t监控统计
 * @throws
 * @author xiaobo
 *  @date 2020/8/28 3:29 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "monitorCount") //映射的表名称
public class MonitorCount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "类型", example = "1")
    private Integer value;
    private String label;
}
