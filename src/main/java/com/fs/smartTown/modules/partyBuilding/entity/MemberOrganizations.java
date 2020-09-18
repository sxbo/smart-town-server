package com.fs.smartTown.modules.partyBuilding.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
 * 　　* @description: TODO  党员信息
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 *
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "spb_member_organizations") //映射的表名称
public class MemberOrganizations {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userId;
    private Integer idCardType;
    @Column(name = "[group]")
    private String group;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    private String phone;
    private String headImg;
    // 1 党书记  2、普通党员
    private Integer jobType;
}
