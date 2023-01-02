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
	
	@PostMapping("/products/{key}")
	public ResponseEntity<Products> addProductsHandler(@RequestBody Products products, @PathVariable String key){
		Products  p = adminService.addProducts(products, key);
		return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/orderdetails/{id}/{key}")
	public ResponseEntity<OrderDetails> viewOrderDetailsHandler(@PathVariable Integer id , @PathVariable String key){
		OrderDetails od = adminService.viewOrderDetails(id, key);
		return new ResponseEntity<>(od,HttpStatus.OK);
	}
	
	@GetMapping("/orders/{id}/{key}")
	public ResponseEntity<Orders> viewOrdersByOrderIdHandler(@PathVariable Integer orderid , @PathVariable String key){
		Orders od = ordersService.viewOrders(orderid, key);
		return new ResponseEntity<>(od,HttpStatus.OK);
	}
	
	@GetMapping("/orders/{key}")
	public ResponseEntity<List<Orders>> viewOrdersByCustomerEmailHandler(@RequestParam("email") String email , @PathVariable String key){
		List<Orders> list = ordersService.serachOrderByCustomersEmail(email, key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping("/orders/{key}")
	public ResponseEntity<Orders> viewOrdersByCustomerIdHandler(@RequestBody Integer customerid, @PathVariable String key){
		Orders od = ordersService.viewOrders(customerid, key);
		return new ResponseEntity<>(od,HttpStatus.OK);
	}
	
	@PostMapping("/category/{key}")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category category, @PathVariable String key){
		Category  p = adminService.addCategory(category, key);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@PostMapping("/cancelledorders/{key}")
	public ResponseEntity<List<Orders>> viewCancelledOrdersHandler(@PathVariable String key){
		List<Orders> list = ordersService.viewCancelledOrders(key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{key}")
	public ResponseEntity<List<Customers>> viewAllCustomersHandler(@PathVariable String key){
		List<Customers> list = adminService.viewAllCustomers(key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/orders/date/{key}")
	public ResponseEntity<List<Orders>> viewAllOrdersByDateHandler(@RequestParam("startdate") String date, @PathVariable String key){
		List<Orders> list = ordersService.salesByDate(date, key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/orders/startdate/enddate/{key}")
	public ResponseEntity<List<Orders>> viewAllOrdersByDateHandler(@RequestParam("startdate") String startDate,@RequestParam("enddate") String endDate, String key){
		List<Orders> list = ordersService.salesByDuration(startDate, endDate, key);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}
