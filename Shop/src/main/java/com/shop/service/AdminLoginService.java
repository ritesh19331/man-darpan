package com.shop.service;

import com.shop.exception.AdminException;
import com.shop.model.Admin;
import com.shop.model.CurrentAdminSession;

public interface AdminLoginService {	
	
	public Admin login(String email, String password) throws AdminException;
	public String logout(String key) throws AdminException;
	
	
}
