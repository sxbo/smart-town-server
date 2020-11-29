package com.fs.smartTown.modules.dataRegister.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description 宣传视频
 * @throws
 * @author Target
 *  @date 2020/8/28 3:29 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "promotional_video") //映射的表名称
public class PromotionalVideo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String url;
}
