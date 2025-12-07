package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String index() {
		return "Index";
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
}

