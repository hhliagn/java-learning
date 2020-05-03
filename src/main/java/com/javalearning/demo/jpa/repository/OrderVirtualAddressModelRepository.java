package com.javalearning.demo.jpa.repository;

import com.javalearning.demo.jpa.model.OrderVirtualAddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderVirtualAddressModelRepository extends JpaRepository<OrderVirtualAddressModel, Integer> {
}
