package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.AdminDao;
import com.shop.dao.CategoryDao;
import com.shop.dao.CurrentSessionDao;
import com.shop.dao.CustomersDao;
import com.shop.dao.OrderDetailsDao;
import com.shop.dao.OrdersDao;
import com.shop.dao.ProductDao;
import com.shop.enums.OrderStatus;
import com.shop.exception.AdminException;
import com.shop.exception.CategoryException;
import com.shop.exception.CustomerException;
import com.shop.exception.OrderException;
import com.shop.exception.ProductException;
import com.shop.model.Admin;
import com.shop.model.Category;
import com.shop.model.CurrentAdminSession;
import com.shop.model.Customers;
import com.shop.model.OrderDetails;
import com.shop.model.Orders;
import com.shop.model.Products;

@Service
public class AdminServiceImpl implements  AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ProductDao prodDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	@Autowired
	private CustomersDao cuDao;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Autowired
	private CategoryDao categoryDao;
	

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		
		Admin ad = adminDao.findByEmail(admin.getEmail());
		
		if(ad!=null)
			throw new AdminException("Admin Already Registered With This Email");
		
		return adminDao.save(admin);
	}


	@Override
	public Products addProducts(Products product, String key) throws ProductException, AdminException {
		checkCurrentSession(key);
		if(product==null) {
			throw new ProductException("Enter a Valid Product");
		}
		Products products =	prodDao.save(product);
		return products;
	}


	@Override
	public OrderDetails viewOrderDetails(Integer id,String key) throws ProductException, AdminException {
		checkCurrentSession(key);
		Optional<OrderDetails> od =	orderDetailsDao.findById(id);
		if(od.isEmpty())
			throw new ProductException("Order Details Not Found for id :"+id);
		
		return od.get();
	}



	@Override
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException {
		CurrentAdminSession cs  =	currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("Admin Not Logged in With "+key);
		
		return cs;
	}


	@Override
	public Category addCategory(Category category ,String key) throws ProductException, AdminException {
		checkCurrentSession(key);
		if(category==null)
			throw new CategoryException("Enter proper details to add catgeory");
		
		return categoryDao.save(category);
	}


	


	@Override
	public List<Customers> viewAllCustomers(String key) throws CustomerException {
		checkCurrentSession(key);
		List<Customers> list =	cuDao.findAll();
		if(list.size()==0) 
			throw new CustomerException("No Customer Found");
		
		return list;
	}
	
}
