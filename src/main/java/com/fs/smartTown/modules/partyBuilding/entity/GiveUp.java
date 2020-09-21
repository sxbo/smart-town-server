package com.fs.smartTown.modules.partyBuilding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 　　* @description: TODO  点赞
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "spb_interactive_give") //映射的表名称
public class GiveUp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer giveId;
    private Integer bbsId;
    private String userId;
    private String nickName;
    private String avatarUrl;
    //点赞类型 1、已点赞 2、未点赞
    private Integer giveType;
}
