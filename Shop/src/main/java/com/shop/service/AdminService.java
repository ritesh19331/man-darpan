package com.shop.service;

import java.util.List;

import com.shop.exception.AdminException;
import com.shop.exception.CustomerException;
import com.shop.exception.ProductException;
import com.shop.model.Admin;
import com.shop.model.Category;
import com.shop.model.CurrentAdminSession;
import com.shop.model.Customers;
import com.shop.model.OrderDetails;
import com.shop.model.Orders;
import com.shop.model.Products;

public interface AdminService {
	
	public Admin registerAdmin(Admin admin) throws AdminException;
	
	public Products addProducts(Products produuct, String key) throws ProductException , AdminException;
	
	public OrderDetails viewOrderDetails(Integer id, String key) throws ProductException , AdminException;
	
	
	
	public Category addCategory(Category category ,String key) throws ProductException , AdminException;
	
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException;
	
	
	
	public List<Customers> viewAllCustomers(String key) throws CustomerException;
	
	
}
