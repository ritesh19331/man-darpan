package com.shop.service;

import com.shop.exception.AdminException;
import com.shop.exception.ProductException;
import com.shop.model.CurrentAdminSession;
import com.shop.model.Products;

public interface ProductsService {
	
	public Products addProducts(Products produuct, String key) throws ProductException , AdminException;
	
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException;
	
}
