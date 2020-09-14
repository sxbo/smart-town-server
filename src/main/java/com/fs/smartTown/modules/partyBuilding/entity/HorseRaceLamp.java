package com.fs.smartTown.modules.partyBuilding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @GeneratedValue
    private Long id;
    private String title;
    private String link;
}
