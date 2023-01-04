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

import com.shop.model.Admin;
import com.shop.model.Category;
import com.shop.model.Customers;
import com.shop.model.LoginDTO;
import com.shop.model.OrderDetails;
import com.shop.model.Orders;
import com.shop.model.Products;
import com.shop.service.AdminLoginService;
import com.shop.service.AdminService;
import com.shop.service.OrdersService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private AdminLoginService adminLoginService;
	

	
	@PostMapping("/register")
	public ResponseEntity<Admin> adminRegisterHandler(@RequestBody Admin admin){
		Admin ad = adminService.registerAdmin(admin);
		return new ResponseEntity<>(ad,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdminHandler(@RequestBody LoginDTO loginDTO){
		Admin ad = adminLoginService.login(loginDTO.getEmail(),loginDTO.getPassword());
		return new ResponseEntity<>(ad,HttpStatus.OK);
	}
	
	@GetMapping("/logout/{key}")
	public ResponseEntity<String> logoutAdminHandler(@PathVariable String key){
		String message = adminLoginService.logout(key);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	
	
	
}
