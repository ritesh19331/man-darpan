package com.shop.service;

import com.shop.exception.CustomerException;
import com.shop.model.Customers;

public interface CustomerLoginService {
	
	public Customers login(String email, String password) throws CustomerException;
	public String logout(String key) throws CustomerException;
}
