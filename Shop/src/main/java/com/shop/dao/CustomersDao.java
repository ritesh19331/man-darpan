package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Customers;

public interface CustomersDao extends JpaRepository<Customers, Integer> {
	
	public Customers findByEmail(String email);
	
}
