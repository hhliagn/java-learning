package com.javalearning.demo.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "t_order_info")
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@JsonIgnoreProperties(value = {"hibernate_lazy_initializer", "handler", "field_handler"})
public class OrderModel { //source: https://thoughts-on-java.org/ultimate-guide-association-mappings-jpa-hibernate/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String name;

    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

    /**
     * 一对一
     */
    @OneToOne(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private OrderVirtualAddressModel virtualAddress;

    public void addVirtualAddress(OrderVirtualAddressModel orderVirtualAddressModel){
        this.virtualAddress = orderVirtualAddressModel;
        orderVirtualAddressModel.setOrder(this);
    }


    /**
     * 一对多
     */
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<AfterServiceModel> afterservices;

    public void addServices(AfterServiceModel afterServiceModel){
        if (this.afterservices == null){
            this.afterservices = new ArrayList<>();
        }
        this.afterservices.add(afterServiceModel);
        afterServiceModel.setOrder(this);
    }


    /**
     * 多对多
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Coffee> coffees;


    /**
     * 同表关联
     */
    /**
     * 子单
     */
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private List<OrderModel> children;

    /**
     * 父单
     */
    @ManyToOne
    @JoinColumn(name = "parentOrderId", referencedColumnName = "orderId")
    private OrderModel parent;

    /**
     * 父单id
     */
    @Column(insertable = false, updatable = false)
    private Integer parentOrderId;

    public void addChild(OrderModel child){
        if (this.children == null){
            this.children = new ArrayList<>();
        }
        this.children.add(child);
        child.setParent(this);
    }
}
