package com.shop.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.AdminDao;
import com.shop.dao.CurrentSessionDao;
import com.shop.exception.AdminException;
import com.shop.model.Admin;
import com.shop.model.CurrentAdminSession;

import net.bytebuddy.utility.RandomString;


@Service
public class AdminLoginServiceImpl implements AdminLoginService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Override
	public Admin login(String email, String password) throws AdminException {
		
		Admin admin =	adminDao.findByEmail(email);
		if(admin==null) {
			throw new AdminException("Admin Not Registered With : "+email);
		}
		
		if(!admin.getPassword().equals(password))
			throw new AdminException("Please Enter Correct Password");
		
		String key = RandomString.make();
		
		currentSessionDao.save(new CurrentAdminSession(admin.getId(), key,LocalDateTime.now()));
		
		return admin;
		
	}

	@Override
	public String logout(String key) throws AdminException {
		
		CurrentAdminSession cs = currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("User Not Found With the Key : "+ key);
		
		currentSessionDao.deleteById(cs.getId());
		return "User Logged Out Successfully";
		
	}
	
	
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException {
		AdminLoginServiceImpl alsi = new AdminLoginServiceImpl();
		CurrentAdminSession cs  =alsi.currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("Admin Not Logged in With "+key);
		
		return cs;
	}
	
	
	
}
