package com.shop.service;

import java.util.List;

import com.shop.exception.AdminException;
import com.shop.exception.PaymentsException;
import com.shop.model.Payments;

public interface PaymentsService {
	
	public List<Payments> viewAllPayments(String key) throws PaymentsException , AdminException; 
	
	public Payments viewPaymentsById(Integer pid, String key) throws PaymentsException;
	
}
