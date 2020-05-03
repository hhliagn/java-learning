package com.javalearning.demo.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * 虚拟商品订单虚拟收货信息
 */
@Setter
@Getter
@ToString
@Entity(name = "t_order_virtual_address")
public class OrderVirtualAddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(insertable = false, updatable = false)
    private Integer orderId;

    private String name;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "orderId")
    private OrderModel order;
}
