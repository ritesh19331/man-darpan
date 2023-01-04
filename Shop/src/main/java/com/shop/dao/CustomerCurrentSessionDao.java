package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.CurrentCustomerSession;

public interface CustomerCurrentSessionDao  extends JpaRepository<CurrentCustomerSession, Integer>{
	

	
	
}
