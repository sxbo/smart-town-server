package com.fs.smartTown.modules.partyBuilding.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
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
}
