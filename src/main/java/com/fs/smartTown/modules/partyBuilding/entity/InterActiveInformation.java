package com.fs.smartTown.modules.partyBuilding.entity;

import com.fs.smartTown.modules.auth.entity.Role;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 　　* @description: TODO  互动信息
 * 　　* @throws
 * 　　* @author Target
 * 　　* @date 2020/9/9 4:35 下午
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "spb_interactive_information") //映射的表名称
public class InterActiveInformation {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String userId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "spb_comment",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "userId")}
    )
    private Set<Comment> comments;
}
