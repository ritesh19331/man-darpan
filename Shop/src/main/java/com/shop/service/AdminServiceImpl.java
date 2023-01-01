package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.AdminDao;
import com.shop.exception.AdminException;
import com.shop.model.Admin;

@Service
public class AdminServiceImpl implements  AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	
	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		
		Admin ad = adminDao.findByEmail(admin.getEmail());
		
		if(ad!=null)
			throw new AdminException("Admin Already Registered With This Email");
		
		return adminDao.save(admin);
	}

}
