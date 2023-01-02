package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {

}
