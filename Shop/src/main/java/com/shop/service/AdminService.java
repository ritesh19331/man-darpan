package com.shop.service;

import com.shop.exception.AdminException;
import com.shop.model.Admin;

public interface AdminService {
	
	public Admin registerAdmin(Admin admin) throws AdminException;
	
}
