package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CustomerCurrentSessionDao;
import com.shop.dao.CustomersDao;
import com.shop.exception.CustomerException;
import com.shop.model.Customers;
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
	@Autowired
	private CustomerCurrentSessionDao customerCurrentSessionDao;

	@Autowired
	private CustomersDao customersDao;
	

	@Override
	public Customers login(String email, String password) throws CustomerException {
		Customers c =	customersDao.findByEmail(email);
		if(c==null)
			throw new CustomerException("Customer not registered with email: "+email);
		
		return null;
		
	}

	@Override
	public String logout(String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
