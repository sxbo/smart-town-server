package com.fs.smartTown.modules.dataRegister.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * 　　* @description: TODO  农副产品动态
 * 　　* @throws
 * 　　* @author xiaobo
 * 　　* @date 2020/9/9 4:35 下午
 *
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "farm_product_information") //映射的表名
public class FarmProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String subTitle;
    private String content;
    private String userName;
    private String icon;
    //1 、苹果 2，葡萄， 3，冬枣 4，茶叶，5，石榴
    @OneToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "type", referencedColumnName="id")
    private FarmProductType type;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date createTime;
}
