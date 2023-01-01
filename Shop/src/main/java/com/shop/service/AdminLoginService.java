package com.shop.service;

import com.shop.exception.AdminException;
import com.shop.model.Admin;

public interface AdminLoginService {	
	
	public Admin login(String email, String password) throws AdminException;
	public String logout(String key) throws AdminException;
}
