package com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.CurrentCustomerSession;

public interface CustomerCurrentSessionDao  extends JpaRepository<CurrentCustomerSession, Integer>{
	

	public CurrentCustomerSession findByUuid(String uuid);
	
}
