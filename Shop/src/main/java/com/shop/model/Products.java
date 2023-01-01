package com.shop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String Brand;
	private Double salePrice;
	private Double marketPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails orderDetails;
	
}
