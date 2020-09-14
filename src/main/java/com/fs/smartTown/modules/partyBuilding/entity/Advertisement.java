package com.fs.smartTown.modules.partyBuilding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @GeneratedValue
    private Long id;
    private String imageUrl;
    private String link;
}
