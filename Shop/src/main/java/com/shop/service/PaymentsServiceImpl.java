package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CurrentSessionDao;
import com.shop.dao.PaymentsDao;
import com.shop.exception.AdminException;
import com.shop.exception.PaymentsException;
import com.shop.model.CurrentAdminSession;
import com.shop.model.Payments;

@Service
public class PaymentsServiceImpl implements PaymentsService {
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Autowired
	private PaymentsDao paymentsDao; 
	
	@Override
	public List<Payments> viewAllPayments(String key) throws PaymentsException , AdminException {
		
		CurrentAdminSession cuAdminSession =	currentSessionDao.findByUuid(key);
		if(cuAdminSession==null)
			throw new AdminException("Admin Not found With uuid :"+key);
		
		List<Payments> list =	paymentsDao.findAll();
		
		if(list.size()==0)
			throw new PaymentsException("No payments id found... ");
		
		return list;
	}
	
	
	
	
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException {
		CurrentAdminSession cs  =	currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("Admin Not Logged in With "+key);
		
		return cs;
	}




	@Override
	public Payments viewPaymentsById(Integer pid, String key) throws PaymentsException {
		CurrentAdminSession cs = currentSessionDao.findByUuid(key);
		
		if(cs==null)
			throw new PaymentsException("Admin Not found with id : "+key);
		
		Optional<Payments> opt =	paymentsDao.findById(pid);
		if(opt.isEmpty())
			throw new PaymentsException("Payments ");
		
		return opt.get();
	}
}
