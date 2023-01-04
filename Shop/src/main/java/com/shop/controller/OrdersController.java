package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dao.OrdersDao;
import com.shop.model.Orders;
import com.shop.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	
	@GetMapping("/cancelledorders/{key}")
	public ResponseEntity<List<Orders>> viewCancelledOrdersHandler(@PathVariable("key") String key){
		List<Orders> list = ordersService.viewCancelledOrders(key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{key}")
	public ResponseEntity<List<Orders>> viewAllOrdersByDateHandler(@RequestParam("startdate") String startDate,@RequestParam("enddate") String endDate,@PathVariable("key") String key){
		List<Orders> list = ordersService.salesByDuration(startDate, endDate, key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/ordersbydate/{key}")
	public ResponseEntity<List<Orders>> viewAllOrdersByDateHandler(@RequestParam("startdate") String date, @PathVariable("key") String key){
		List<Orders> list = ordersService.salesByDate(date, key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{orderid}/{key}")
	public ResponseEntity<Orders> viewOrdersByOrderIdHandler(@PathVariable("orderid") Integer orderid , @PathVariable("key") String key){
		Orders od = ordersService.viewOrders(orderid, key);
		return new ResponseEntity<>(od,HttpStatus.OK);
	}
	
	@GetMapping("/byemail/{key}")
	public ResponseEntity<List<Orders>> viewOrdersByCustomerEmailHandler(@RequestParam("email") String email , @PathVariable("key") String key){
		List<Orders> list = ordersService.serachOrderByCustomersEmail(email, key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping("/{customerid}/{key}")
	public ResponseEntity<Orders> viewOrdersByCustomerIdHandler(@PathVariable("customerid") Integer customerid, @PathVariable("key") String key){
		Orders od = ordersService.viewOrders(customerid, key);
		return new ResponseEntity<>(od,HttpStatus.OK);
	}
}
