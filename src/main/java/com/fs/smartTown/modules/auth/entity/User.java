package com.fs.smartTown.modules.auth.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
public class User {
    @Id
    private Integer userId;
    private String username;
    private String password;
    private String phone;
    //创建时间
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date createTime;
    //跟新时间
    @Temporal(TemporalType.TIME)
    private Date updateTime;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")})
    private Set<Role> roles;
}

