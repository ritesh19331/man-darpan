package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CurrentSessionDao;
import com.shop.dao.ProductDao;
import com.shop.exception.AdminException;
import com.shop.exception.ProductException;
import com.shop.model.CurrentAdminSession;
import com.shop.model.Products;
@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Override
	public Products addProducts(Products product, String key) throws ProductException, AdminException {
		
		if(product==null) {
			throw new ProductException("Enter a Valid Product");
		}
		Products products =	productDao.save(product);
		
		return products;
	}
	
	@Override
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException {
		CurrentAdminSession cs  =	currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("Admin Not Logged in With "+key);
		
		return cs;
	}
	
	
}
