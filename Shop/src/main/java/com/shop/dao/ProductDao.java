package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Products;

public interface ProductDao extends JpaRepository<Products, Integer>{

}
