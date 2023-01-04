package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CategoryDao;
import com.shop.dao.CurrentSessionDao;
import com.shop.exception.AdminException;
import com.shop.exception.CategoryException;
import com.shop.exception.ProductException;
import com.shop.model.Category;
import com.shop.model.CurrentAdminSession;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Category addCategory(Category category ,String key) throws ProductException, AdminException {
		checkCurrentSession(key);
		if(category==null)
			throw new CategoryException("Enter proper details to add catgeory");
		
		return categoryDao.save(category);
	}
	
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException {
		CurrentAdminSession cs  =	currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("Admin Not Logged in With "+key);
		
		return cs;
	}
}
