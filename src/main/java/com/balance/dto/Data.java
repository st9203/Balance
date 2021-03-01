package com.balance.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	private String theme;
	private String A;
	private String B;
	
}
