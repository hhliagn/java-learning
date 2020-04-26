package com.javalearning.demo.commonmistakes.nullvalue.pojonull;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
@DynamicUpdate
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String nickname;
    @CreationTimestamp
    private Date createTime;
}
