package com.fs.smartTown.modules.dataRegister.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "price_sell") //映射的表名
public class PriceSell {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "type", referencedColumnName = "id")
    private FarmCount type;
    @OneToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "village", referencedColumnName="id")
    private MemberCount village;
    private String daySell;
    private String price;
}
