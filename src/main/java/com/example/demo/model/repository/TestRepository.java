package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.domain.TestDB;

@Repository
public interface TestRepository extends JpaRepository<TestDB, Long> {
	
	List<TestDB> findByName(String name);
}

