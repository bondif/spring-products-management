package com.bondif.springProductsManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bondif.springProductsManagement.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByDesignationContaining(String designation);
}
