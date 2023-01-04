package com.shop.service;

import java.util.List;

import com.shop.exception.CustomerException;
import com.shop.model.Customers;

public interface CustomerService {
	
	public List<Customers> viewAllCustomers(String key) throws CustomerException;
}
