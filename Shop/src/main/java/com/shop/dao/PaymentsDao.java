package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Payments;

public interface PaymentsDao extends JpaRepository<Payments, Integer> {
	
	

}
