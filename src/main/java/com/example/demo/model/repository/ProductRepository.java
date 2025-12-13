package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// 이름으로 상품 찾기
	List<Product> findByName(String name);
	
	// 가격으로 상품 찾기 (가격보다 큰 것)
	List<Product> findByPriceGreaterThan(Double price);
}

