package com.fs.smartTown.modules.partyBuilding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    //1 、新闻资讯 2、范家故事 3、农副产品 4、相关政策 5、相关公告 6、党建动态 7、三会一课
    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
}
