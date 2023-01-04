package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CurrentSessionDao;
import com.shop.dao.OrderDetailsDao;
import com.shop.exception.AdminException;
import com.shop.exception.ProductException;
import com.shop.model.CurrentAdminSession;
import com.shop.model.OrderDetails;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Override
	public OrderDetails viewOrderDetails(Integer id,String key) throws ProductException, AdminException {
		checkCurrentSession(key);
		Optional<OrderDetails> od =	orderDetailsDao.findById(id);
		if(od.isEmpty())
			throw new ProductException("Order Details Not Found for id :"+id);
		
		return od.get();
	}



	
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException {
		CurrentAdminSession cs  =	currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("Admin Not Logged in With "+key);
		
		return cs;
	}
}
