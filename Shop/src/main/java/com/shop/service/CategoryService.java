package com.shop.service;

import com.shop.exception.AdminException;
import com.shop.exception.ProductException;
import com.shop.model.Category;

public interface CategoryService {
	
	
	public Category addCategory(Category category ,String key) throws ProductException , AdminException;
	
}
