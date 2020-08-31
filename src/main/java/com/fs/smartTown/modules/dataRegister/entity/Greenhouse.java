package com.fs.smartTown.modules.dataRegister.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description 大棚
 * @throws
 * @author Target
 *  @date 2020/8/28 3:29 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "greenhouse") //映射的表名称
public class Greenhouse {
    @Id
    @GeneratedValue
    private Long id;
    private String manage;
    private String phone;
    private Integer type;
    private String name;
}
