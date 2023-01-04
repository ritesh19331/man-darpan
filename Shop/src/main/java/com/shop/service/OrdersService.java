package com.shop.service;

import java.time.LocalDate;
import java.util.List;

import com.shop.exception.AdminException;
import com.shop.exception.ProductException;
import com.shop.model.CurrentAdminSession;
import com.shop.model.Orders;

public interface OrdersService {
	
	//Admin...........................................................................
	
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException; 
	
	public List<Orders> viewCancelledOrders(String key) throws AdminException;
	
	public Orders viewOrders(Integer orderId, String key) throws ProductException , AdminException;
	
	public List<Orders> serachOrderByCustomersEmail(String email, String key) throws ProductException;
	
	public List<Orders> searchOrderByCustomerId(Integer customerId, String key) throws ProductException;
	
	public List<Orders> salesByDate(String localDate, String key);
	
	public List<Orders> salesByDuration(String startDate, String endDate, String key);
	
	
	//Common...................................................................................
	

	
	
	
	
}
