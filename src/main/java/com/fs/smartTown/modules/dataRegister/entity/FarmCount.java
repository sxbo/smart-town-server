package com.fs.smartTown.modules.dataRegister.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "farmCount") //映射的表名称
public class FarmCount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "类型", example = "1")
    private Integer count;
    private String type;
}
