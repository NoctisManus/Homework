package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.domain.TestDB;
import com.example.demo.model.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public TestDB findByName(String name) {
		List<TestDB> results = testRepository.findByName(name);
		if (results != null && !results.isEmpty()) {
			return results.get(0);
		}
		return null;
	}
}

