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
@Setter
@Getter
@ToString
@Entity
@Table(name = "screen_monitor") //大屏中三个监控的表名称
public class ScreenMonitor {
    @Id
    @ApiModelProperty(value = "ID", example = "1")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    /*
    * 监控序列号
    * */
    private String seriaNumber;
    /*
    * channelNo 设备通道
    * */
    private String channelNo;
}
