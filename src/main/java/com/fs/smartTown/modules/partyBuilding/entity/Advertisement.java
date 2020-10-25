package com.fs.smartTown.modules.partyBuilding.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 　　* @description: TODO  跑马灯
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:31 下午
 *
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "spb_advertisement") //映射的表名称
public class Advertisement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String imageUrl;
    private String link;
    @Column(columnDefinition="MEDIUMTEXT")
    private String content;
    //1 、党建 2、首页
    private Integer type;
}
