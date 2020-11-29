package com.fs.smartTown.modules.dataRegister.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "poor_count")
public class PoorCount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String year;
    private Integer poorNumber;
    private Integer outPoorNumber;
}
