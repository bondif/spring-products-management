package com.bondif.springProductsManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringProductsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductsManagementApplication.class, args);
	}

}
