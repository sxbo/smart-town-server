package com.fs.smartTown.modules.partyBuilding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 　　* @description: TODO  Banner 广告
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 *
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "spb_horse_race_lamp") //映射的表名称
public class HorseRaceLamp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String link;
    @Column(columnDefinition="MEDIUMTEXT")
    private String content;
    //1 、党建 2、首页
    private Integer type;
    private String userName;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;

}
