package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Products;
import com.shop.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@PostMapping("/{key}")
	public ResponseEntity<Products> addProductsHandler(@RequestBody Products products, @PathVariable String key){
		Products  p = productsService.addProducts(products, key);
		return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
	}
}
