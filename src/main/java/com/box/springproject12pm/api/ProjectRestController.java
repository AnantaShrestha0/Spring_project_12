package com.box.springproject12pm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.box.springproject12pm.model.Product;
import com.box.springproject12pm.service.ProductService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Controller
@OpenAPIDefinition(info= @Info(title="Product REST API",version ="5.0",description="Product API"))
public class ProjectRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/load")
	private String loadProducts() {
		RestTemplate tmp=new RestTemplate();
		Product[] product=tmp.getForObject("https://fakestoreapi.com/products",Product[].class);
		productService.addproduct(product);
		return "success";
	}
}
