package com.fs.smartTown.modules.partyBuilding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.*;

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
    //1 、新闻资讯 2、范家故事  3、相关政策 4、相关公告 5、党建动态 6、三会一课 7、主题教育
    @OneToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "dynamic_type_id", referencedColumnName="id")
    private DynamicType type;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;
}
