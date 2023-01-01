package com.shop.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderDetailsId;
	
	private Integer qunatity;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Orders orders;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Suppliers suppliers;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Products products;
}
