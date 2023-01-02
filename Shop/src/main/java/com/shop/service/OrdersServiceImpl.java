package com.shop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.AdminDao;
import com.shop.dao.CategoryDao;
import com.shop.dao.CurrentSessionDao;
import com.shop.dao.CustomersDao;
import com.shop.dao.OrderDetailsDao;
import com.shop.dao.OrdersDao;
import com.shop.dao.ProductDao;
import com.shop.enums.OrderStatus;
import com.shop.exception.AdminException;
import com.shop.exception.CustomerException;
import com.shop.exception.OrderException;
import com.shop.exception.ProductException;
import com.shop.model.CurrentAdminSession;
import com.shop.model.Customers;
import com.shop.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ProductDao prodDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	@Autowired
	private CustomersDao cuDao;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;
	
	@Autowired
	private CategoryDao categoryDao;
	


	@Override
	public Orders viewOrders(Integer orderId, String key) throws ProductException, AdminException {
		checkCurrentSession(key);
		Optional<Orders> opt =	ordersDao.findById(orderId);
		if(opt.isEmpty())
			throw new ProductException("Order unvailable with id : "+orderId);
		
		
		return opt.get();
	}


	@Override
	public List<Orders> serachOrderByCustomersEmail(String email, String key) throws ProductException {
		checkCurrentSession(key);
		Customers c =	cuDao.findByEmail(email);
		if(c==null)
			throw new CustomerException("Customer not found with email :"+email);
		
		List<Orders> list =	c.getOrderList();

		return list;
	}


	@Override
	public List<Orders> searchOrderByCustomerId(Integer customerId, String key) throws ProductException {
		checkCurrentSession(key);
		Optional<Customers> opt = cuDao.findById(customerId);
		if(opt.isEmpty())
			throw new CustomerException("Customer Not Found With id : "+customerId);
		return opt.get().getOrderList();
	}
	
	@Override
	public CurrentAdminSession checkCurrentSession(String key) throws AdminException {
		CurrentAdminSession cs  =	currentSessionDao.findByUuid(key);
		if(cs==null)
			throw new AdminException("Admin Not Logged in With "+key);
		
		return cs;
	}
	
	@Override
	public List<Orders> viewCancelledOrders(String key) throws AdminException ,OrderException{
		checkCurrentSession(key);
		List<Orders> ls =	ordersDao.findByOrderStatus(OrderStatus.CANCELLED);
		if(ls.size()==0)
			throw new OrderException("Cancelled Orders Not Found");
		
		return ls;
	}

	@Override
	public List<Orders> salesByDate(String localdate,String key) {
		LocalDate date = LocalDate.parse(localdate);
		checkCurrentSession(key);
		List<Orders> ls = ordersDao.findByOrderDate(date);
		return ls;
	}


	@Override
	public List<Orders> salesByDuration(String startDate, String endDate, String key) {
		checkCurrentSession(key);
		LocalDate date1 = LocalDate.parse(startDate);
		LocalDate date2 = LocalDate.parse(endDate);
		
		List<Orders> list = ordersDao.findOrdersByDuration(date1, date2);
		if(list.size()==0)
			throw new OrderException("Orders not found beetween "+date1+" and "+date2);
		
		return list;
	}

	
}
