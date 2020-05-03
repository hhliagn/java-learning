package com.javalearning.demo.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name = "t_after_service")
@JsonIgnoreProperties(value = {"hibernate_lazy_initializer", "handler", "field_handler"})
public class AfterServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;      //服务单id(单号不存储临时生成)

    private Integer companyId;      //企业id

    private Integer userId;         //用户id

    @Column(insertable = false, updatable = false)
    private Integer orderId;        //订单id

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderModel order;       //对应订单

}
