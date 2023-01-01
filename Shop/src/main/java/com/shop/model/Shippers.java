package com.shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Shippers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shipperId;
	private String companyName;
	private String phone;
	@OneToMany(mappedBy = "shippers" , cascade = CascadeType.ALL)
	private List<Orders> orderlist = new ArrayList<>();
}
