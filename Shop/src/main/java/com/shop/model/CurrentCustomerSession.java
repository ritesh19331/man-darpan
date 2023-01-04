package com.shop.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrentCustomerSession {
	
	@Id
	@Column(unique = true)
	private Integer id;
	private String uuid;
	private LocalDateTime logintime;
	
	
}
