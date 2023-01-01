package com.shop.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.CurrentAdminSession;

public interface CurrentSessionDao extends JpaRepository<CurrentAdminSession, Integer>{

	
	public CurrentAdminSession findByUuid(String key) ;

}
