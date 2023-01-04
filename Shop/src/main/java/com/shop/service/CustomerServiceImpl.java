package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CurrentSessionDao;
import com.shop.dao.CustomersDao;
import com.shop.exception.AdminException;
import com.shop.exception.CustomerException;
import com.shop.model.CurrentAdminSession;
import com.shop.model.Customers;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomersDao customersDao;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Override
	public List<Customers> viewAllCustomers(String key) throws CustomerException {
		checkCurrentSession(key);
		List<Customers> list =	customersDao.findAll();
		if(list.size()==0) 
			throw new CustomerException("No Customer Found");
		
		return list;
	}
	
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException {
		CurrentAdminSession cs  =	currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("Admin Not Logged in With "+key);
		
		return cs;
	}

}
