package com.shop.service;

import com.shop.exception.AdminException;
import com.shop.exception.ProductException;
import com.shop.model.OrderDetails;

public interface OrderDetailsService {
	
	public OrderDetails viewOrderDetails(Integer id, String key) throws ProductException , AdminException;
}
