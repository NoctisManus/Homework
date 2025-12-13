package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.domain.TestDB;
import com.example.demo.model.service.TestService;

@Controller
public class DemoController {
	
	@Autowired
	private TestService testService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/hello.html")
	public String hello(Model model) {
		model.addAttribute("data", "방갑습니다");
		return "Hello";
	}
	
	@GetMapping("/hello2")
	public String hello2(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("greeting", "방갑습니다");
		model.addAttribute("date", "오늘");
		model.addAttribute("Signalstate", "신호 양호");
		model.addAttribute("Status", "사용 가능");
		return "hello2";
	}
	
	@GetMapping("/about_detailed")
	public String about() {
		return "about_detailed";
	}
	
	@GetMapping("/test1")
	public String thymeleaf_test1(Model model) {
		model.addAttribute("data1", "<h2> 방갑습니다 </h2>");
		model.addAttribute("data2", "태그의 속성 값");
		model.addAttribute("link", 01);
		model.addAttribute("name", "홍길동");
		model.addAttribute("para1", "001");
		model.addAttribute("para2", 002);
		
		// 상품 리스트 데이터 추가
		List<Map<String, Object>> allProducts = new ArrayList<>();
		Map<String, Object> product1 = new HashMap<>();
		product1.put("name", "사과");
		product1.put("price", 1500.0);
		allProducts.add(product1);
		
		Map<String, Object> product2 = new HashMap<>();
		product2.put("name", "바나나");
		product2.put("price", 2000.0);
		allProducts.add(product2);
		
		Map<String, Object> product3 = new HashMap<>();
		product3.put("name", "오렌지");
		product3.put("price", 2500.0);
		allProducts.add(product3);
		
		model.addAttribute("allProducts", allProducts);
		
		return "thymeleaf_test1";
	}
	
	@GetMapping("/testdb")
	public String getAllTestDBs(Model model) {
		TestDB test = testService.findByName("홍길동");
		TestDB test2 = testService.findByName("사용자2");
		TestDB test3 = testService.findByName("사용자3");
		model.addAttribute("data4", test);
		model.addAttribute("data5", test2);
		model.addAttribute("data6", test3);
		System.out.println("데이터 출력 디버그 : " + test);
		return "testdb";
	}
}

