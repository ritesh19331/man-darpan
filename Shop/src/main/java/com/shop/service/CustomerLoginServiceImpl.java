package com.shop.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CustomerCurrentSessionDao;
import com.shop.dao.CustomersDao;
import com.shop.exception.CustomerException;
import com.shop.model.CurrentCustomerSession;
import com.shop.model.Customers;
import com.shop.model.LoginDTO;

import net.bytebuddy.utility.RandomString;
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
	@Autowired
	private CustomerCurrentSessionDao customerCurrentSessionDao;

	@Autowired
	private CustomersDao customersDao;
	

	@Override
	public String login(LoginDTO logindto) throws CustomerException {
		Customers c =	customersDao.findByEmail(logindto.getEmail());
		if(c==null)
			throw new CustomerException("Customer not registered with email: "+c.getEmail());
		if(logindto.getEmail().equals(c.getEmail()) && logindto.getPassword().equals(c.getPassword())) {
			String s =RandomString.make();
			customerCurrentSessionDao.save(new CurrentCustomerSession(c.getCustomerId(), s, LocalDateTime.now()));
			return "Login Successfull";
		}
		return "Login Failed";
		
	}

	@Override
	public String logout(String key) throws CustomerException {
		CurrentCustomerSession c =	customerCurrentSessionDao.findByUuid(key);
		if(c==null) {
			throw new CustomerException("Customer not found login with  uuid: "+key);
		}
		customerCurrentSessionDao.delete(c);
		return "Logout Success";
	}

}
