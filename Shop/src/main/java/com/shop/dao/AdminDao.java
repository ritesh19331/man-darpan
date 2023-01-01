package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	public Admin findByEmail(String email);
	
}
