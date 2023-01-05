package com.shop.service;

import com.shop.exception.CustomerException;
import com.shop.model.Customers;
import com.shop.model.LoginDTO;

public interface CustomerLoginService {
	
	public String login(LoginDTO loginDTO) throws CustomerException;
	public String logout(String key) throws CustomerException;
}
