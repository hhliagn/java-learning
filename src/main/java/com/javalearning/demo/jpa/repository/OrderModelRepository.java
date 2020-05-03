package com.javalearning.demo.jpa.repository;

import com.javalearning.demo.jpa.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderModelRepository extends JpaRepository<OrderModel, Integer> {
}
