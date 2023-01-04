package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Customers;
import com.shop.service.CustomerLoginService;
import com.shop.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomersController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerLoginService customerLoginService;

	@GetMapping("/{key}")
	public ResponseEntity<List<Customers>> viewAllCustomersHandler(@PathVariable String key){
		List<Customers> list = customerService.viewAllCustomers(key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
}
