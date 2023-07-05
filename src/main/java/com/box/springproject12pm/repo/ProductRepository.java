package com.box.springproject12pm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.springproject12pm.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
