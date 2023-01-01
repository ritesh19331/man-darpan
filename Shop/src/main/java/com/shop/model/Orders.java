package com.shop.model;

import java.time.LocalDate;

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
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cutomers customers;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Payments payments;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Shippers shippers;
	
	private LocalDate shipDate;
	
	private LocalDate deliveryDate;
	
	private Double total_order_amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails orderDetails;
}
