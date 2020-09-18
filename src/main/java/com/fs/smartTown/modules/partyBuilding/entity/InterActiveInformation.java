package com.fs.smartTown.modules.partyBuilding.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 　　* @description: TODO  互动信息
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "spb_interactive_information") //映射的表名称
public class InterActiveInformation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer bbsId;
    private String title;
    private String content;
    private String userId;
    //点赞类型 1、已点赞 2、未点赞
    private Integer giveType;
    @Embedded
    private List<Comment> comments;
}
