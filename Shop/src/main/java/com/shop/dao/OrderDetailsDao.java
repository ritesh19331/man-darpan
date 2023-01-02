package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.OrderDetails;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

}
