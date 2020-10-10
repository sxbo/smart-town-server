package com.fs.smartTown.modules.partyBuilding.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 　　* @description: TODO  动态信息
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 *
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "spb_dynamic_information") //映射的表名称
public class DynamicInformation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String subTitle;
    private String content;
    private String userName;
    private String icon;
    //1 、党建 2、首页
    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
