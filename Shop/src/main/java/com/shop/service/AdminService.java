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

	public CurrentAdminSession checkCurrentSession(String key) throws AdminException;

	

}
