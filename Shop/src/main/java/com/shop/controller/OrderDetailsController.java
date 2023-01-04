package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.OrderDetails;
import com.shop.service.OrderDetailsService;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@GetMapping("/{id}/{key}")
	public ResponseEntity<OrderDetails> viewOrderDetailsHandler(@PathVariable Integer id , @PathVariable String key){
		OrderDetails od = orderDetailsService.viewOrderDetails(id, key);
		return new ResponseEntity<>(od,HttpStatus.OK);
	}
}
