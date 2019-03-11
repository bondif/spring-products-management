package com.bondif.springProductsManagement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bondif.springProductsManagement.dao.ProductRepository;
import com.bondif.springProductsManagement.entities.Product;

@Controller
public class ProductsController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public String index(Model model,
			@RequestParam(name="query", defaultValue="") String query) {
		List<Product> products;
		
		if(query.equals(""))
			products = productRepository.findAll();
		else
			products = productRepository.findByDesignationContaining(query);
		
		model.addAttribute("products", products);
		
		return "products";
	}
	
	@GetMapping("/create")
	public String create() {
		return "create";
	}
	
	@PostMapping("/store")
	public ModelAndView store(Model model, 
			@RequestParam(name="designation") String designation,
			@RequestParam(name="price") double price) {
		
		productRepository.save(new Product(0, designation, price));
		
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, 
			@PathVariable(name="id") long id) {

		Product product = productRepository.getOne(id);
		model.addAttribute("p", product);
		
		return "edit";
	}

	@PostMapping("/update/{id}")
	public ModelAndView update(@PathVariable(name="id") long id,
			@RequestParam(name="designation") String designation,
			@RequestParam(name="price") double price) {
		
		Product product = productRepository.getOne(id);
		product.setDesignation(designation);
		product.setPrice(price);
		
		productRepository.save(product);
		
		return new ModelAndView("redirect:/");
	}

	@PostMapping("/destroy/{id}")
	public ModelAndView destroy(@PathVariable(name="id") long id) {
		
		Product product = productRepository.getOne(id);
		productRepository.delete(product);
		
		return new ModelAndView("redirect:/");
	}
	
}
