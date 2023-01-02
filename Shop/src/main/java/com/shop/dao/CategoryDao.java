package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
