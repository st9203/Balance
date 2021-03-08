package com.balance.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
@NamedQuery(name= "Data.findByTheme", query = "SELECT d FROM Data d WHERE d.theme = ?1")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	private String theme;
	private String ifMoon;
	private int choice;
	private String A;
	private String B;
	
	
}
