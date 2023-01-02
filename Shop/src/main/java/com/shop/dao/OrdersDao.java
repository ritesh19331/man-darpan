package com.shop.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.enums.OrderStatus;
import com.shop.model.Customers;
import com.shop.model.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>{
	
	public List<Orders> findByCustomers(Customers customers);

	public List<Orders> findByOrderStatus(OrderStatus orderStatus);
	
	public List<Orders> findByOrderDate(LocalDate orderDate);
	
	@Query("select o from Orders o where orderDate>=?1 and orderDate<=?2")
	public List<Orders> findOrdersByDuration(LocalDate startDate, LocalDate endDate);
	
	
}
