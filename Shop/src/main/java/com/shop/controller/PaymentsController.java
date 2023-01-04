package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Payments;
import com.shop.service.PaymentsService;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
	
	@Autowired
	private PaymentsService paymentsService;
	
	@GetMapping("/{pid}/{key}")
	public ResponseEntity<Payments> viewPaymentsByIdHandler(@PathVariable("pid") Integer pid,@PathVariable("key") String key){
		
		Payments  p =paymentsService.viewPaymentsById(pid, key);
		
		return new ResponseEntity<>(p,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{key}")
	public ResponseEntity<List<Payments>> viewAllPaymentsHandler(@PathVariable String key){
		List<Payments> list = paymentsService.viewAllPayments(key);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
