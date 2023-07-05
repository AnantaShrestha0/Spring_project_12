package com.box.springproject12pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.springproject12pm.model.Product;
import com.box.springproject12pm.repo.ProductRepository;
import com.box.springproject12pm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void addproduct(Product[] product) {
		// TODO Auto-generated method stub
		productRepository.saveAll(List.of(product));
	}
}
