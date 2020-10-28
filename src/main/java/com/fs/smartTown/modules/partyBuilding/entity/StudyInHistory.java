package com.fs.smartTown.modules.partyBuilding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 　　* @description: TODO  学习记录
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "spb_study_history") //映射的表名称
public class StudyInHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studyId;
    private Integer userId;
    private String cover;
    private String title;
    private String url;
    @Column(columnDefinition="MEDIUMTEXT")
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;
}
