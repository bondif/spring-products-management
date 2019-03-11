package com.bondif.springProductsManagement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull @Size(min=5, max=255)
	private String designation;
	
	@DecimalMin("100")
	private double price;

	public Product(long id, @NotNull @Size(min = 5, max = 255) String designation, @DecimalMin("100") double price) {
		this.id = id;
		this.designation = designation;
		this.price = price;
	}

	public Product() {
		this.id = 0;
		this.designation = "";
		this.price = 0.0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	
	
}
