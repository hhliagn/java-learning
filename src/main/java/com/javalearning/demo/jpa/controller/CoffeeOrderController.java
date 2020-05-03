package com.javalearning.demo.jpa.controller;

import com.javalearning.demo.jpa.model.AfterServiceModel;
import com.javalearning.demo.jpa.model.Coffee;
import com.javalearning.demo.jpa.model.OrderModel;
import com.javalearning.demo.jpa.model.OrderVirtualAddressModel;
import com.javalearning.demo.jpa.repository.OrderModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
@Slf4j
public class CoffeeOrderController {

    @Autowired
    private OrderModelRepository orderModelRepository;

    /**
     * Many To One example
     * @return
     */
    @PostMapping(path = "/createOrderWithAfterServiceModel")
    public String createOrderWithAfterServiceModel(){
        OrderModel orderModel = new OrderModel();

        AfterServiceModel afterServiceModel = new AfterServiceModel();

        orderModel.setName("aaa");
        orderModel.addServices(afterServiceModel);

        orderModelRepository.save(orderModel);

        return "OK";
    }

    /**
     * One To One example
     * @return
     */
    @PostMapping(path = "/createOrderWithVirtualAddressModel")
    public String createOrderWithVirtualAddressModel(){
        OrderModel orderModel = new OrderModel();

        OrderVirtualAddressModel orderVirtualAddressModel = new OrderVirtualAddressModel();

        orderModel.setName("ccc");
        orderModel.addVirtualAddress(orderVirtualAddressModel);

        orderModelRepository.save(orderModel);

        return "OK";
    }

    /**
     * Many To Many example
     * @return
     */
    @PostMapping(path = "/createOrderWithCoffees")
    public String createOrderWithCoffees(){
        OrderModel orderModel = new OrderModel();

        Set<Coffee> coffeeList = new HashSet<>();

        Coffee coffee1 = new Coffee();
        coffee1.setName("mocha");
        Coffee coffee2 = new Coffee();
        coffee2.setName("latte");

        coffeeList.add(coffee1);
        coffeeList.add(coffee2);

        orderModel.setCoffees(coffeeList);

        orderModelRepository.save(orderModel);

        return "OK";
    }

    /**
     * 同表关联
     * @return
     */
    @PostMapping(path = "/createOrderWithChild")
    public String createOrderWithChild(){
        OrderModel parent = new OrderModel();

        List<OrderModel> childs = new ArrayList<>();

        OrderModel child1 = new OrderModel();
        OrderModel child2 = new OrderModel();

        parent.addChild(child1);
        parent.addChild(child2);

        orderModelRepository.save(parent);

        return "OK";
    }
}
