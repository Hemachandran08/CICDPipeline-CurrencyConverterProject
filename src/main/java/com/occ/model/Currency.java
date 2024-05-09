package com.occ.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code; // Currency code (e.g., USD, EUR)
	private String name; // Currency name (e.g., US Dollar, Euro)
	private double exchangeRate; // Exchange rate relative to INR
	public Currency(Long id, String code, String name, double exchangeRate) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.exchangeRate = exchangeRate;
	}
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	
	
}
